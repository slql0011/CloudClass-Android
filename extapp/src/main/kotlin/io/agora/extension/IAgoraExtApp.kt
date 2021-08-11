package io.agora.extension

import android.content.Context
import android.view.View
import android.widget.RelativeLayout
import io.agora.educontext.EduContextPool

interface IAgoraExtApp {
    fun onExtAppLoaded(context: Context, parent: RelativeLayout, view: View, eduContextPool: EduContextPool?)

    /**
     * Called before extension app is loaded
     */
    fun onCreateView(content: Context): View

    fun onPropertyUpdated(properties: MutableMap<String, Any?>?, cause: MutableMap<String, Any?>?)

    fun onExtAppUnloaded()
}