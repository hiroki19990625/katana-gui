package jp.katana.gui.utils

import javafx.application.Platform
import javafx.scene.control.TextArea
import org.apache.logging.log4j.core.AbstractLifeCycle
import org.apache.logging.log4j.core.Filter
import org.apache.logging.log4j.core.Layout
import org.apache.logging.log4j.core.LogEvent
import org.apache.logging.log4j.core.appender.AbstractAppender
import org.apache.logging.log4j.core.config.plugins.Plugin
import org.apache.logging.log4j.core.config.plugins.PluginAttribute
import org.apache.logging.log4j.core.config.plugins.PluginElement
import org.apache.logging.log4j.core.config.plugins.PluginFactory
import org.apache.logging.log4j.core.layout.PatternLayout
import java.io.Serializable
import java.util.concurrent.locks.ReentrantReadWriteLock

@Plugin(name = "TextAreaAppender", category = "Core", elementType = "appender", printObject = true)
class TextAreaAppender constructor(
    name: String, filter: Filter?,
    layout: Layout<out Serializable>?,
    ignoreExceptions: Boolean
) : AbstractAppender(name, filter, layout, ignoreExceptions, arrayOf()) {
    private val rwLock = ReentrantReadWriteLock()
    private val readLock = rwLock.readLock()

    override fun append(event: LogEvent) {
        readLock.lock()

        val message = String(layout.toByteArray(event))
        try {
            Platform.runLater {
                try {
                    if (textArea != null) {
                        if (textArea!!.text.isEmpty()) {
                            textArea!!.text = message
                        } else {
                            textArea!!.selectEnd()
                            textArea!!.insertText(
                                textArea!!.text.length,
                                message
                            )
                        }
                    }
                } catch (t: Throwable) {
                    println("Error while append to TextArea: " + t.message)
                }
            }
        } catch (ex: IllegalStateException) {
            ex.printStackTrace()

        } finally {
            readLock.unlock()
        }
    }

    companion object {
        @JvmStatic
        private var textArea: TextArea? = null

        @PluginFactory
        @JvmStatic
        fun createAppender(
            @PluginAttribute("name") name: String?,
            @PluginElement("Layout") layout: Layout<out Serializable>?,
            @PluginElement("Filter") filter: Filter?
        ): TextAreaAppender? {
            var layoutVar = layout
            if (name == null) {
                AbstractLifeCycle.LOGGER.error("No name provided for TextAreaAppender")
                return null
            }
            if (layout == null) {
                layoutVar = PatternLayout.createDefaultLayout()
            }

            return TextAreaAppender(name, filter, layoutVar!!, true)
        }

        fun setTextArea(textArea: TextArea) {
            TextAreaAppender.textArea = textArea
        }
    }
}