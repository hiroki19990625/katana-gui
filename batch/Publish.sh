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

mkdir "app/katana-gui/windows/$git_hash"
cp ../build/launch4j/katana-gui.exe "app/katana-gui/windows/$git_hash/katana-gui.exe"
mkdir "app/katana-gui/jar/$git_hash"
cp ../build/libs/katana-gui-1.0-SNAPSHOT.jar "app/katana-gui/jar/$git_hash/katana-gui-1.0-SNAPSHOT.jar"

git add .
git commit -m "publish repo"
git push