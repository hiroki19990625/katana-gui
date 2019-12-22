#!/bin/sh
cd ../

git_hash="$(git rev-parse HEAD)"

current_branch="$(git rev-parse --abbrev-ref HEAD)"
if [ "$current_branch" != "master" ]; then
    exit
fi

chmod 0744 gradlew

repo_dir=repo
if [ ! -d "$repo_dir" ]; then
    git clone "https://github.com/hiroki19990625/maven-repo.git"
    mv maven-repo repo
fi

cd repo

git config --global user.email "ci_user@ci.com"
git config --global user.name "hiroki19990625"

git pull

cd ../
./gradlew createAllExecutables
cd repo

mkdir "app/katana-gui/windows/$git_hash" -p
zip "katana-gui-$git_hash" ../build/launch4j/katana-gui.exe
cp "katana-gui-$git_hash.zip" "app/katana-gui/windows/$git_hash/katana-gui-$git_hash.zip"
mkdir "app/katana-gui/windows/last_version" -p
cp "katana-gui-$git_hash.zip" "app/katana-gui/windows/last_version/katana-gui-$git_hash.zip"
mkdir "app/katana-gui/jar/$git_hash" -p
cp ../build/libs/katana-gui-1.0-SNAPSHOT-all.jar "app/katana-gui/jar/$git_hash/katana-gui-1.0-SNAPSHOT.jar"
mkdir "app/katana-gui/jar/last_version" -p
cp ../build/libs/katana-gui-1.0-SNAPSHOT-all.jar "app/katana-gui/jar/last_version/katana-gui-1.0-SNAPSHOT.jar"
rm "katana-gui-$git_hash.zip"

git add .
git commit -m "publish repo"
git push