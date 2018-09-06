package io.github.benoitduffez.cupsprint

import android.app.Application
import android.content.Context
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import io.fabric.sdk.android.Fabric

class CupsPrintApp : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        val core = CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build()
        Fabric.with(this, Crashlytics.Builder().core(core).build())

//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        } else {
//            Timber.plant(CrashReportingTree())
//        }
    }

    companion object {
        val LOG_TAG = "CUPS"

        var instance: CupsPrintApp? = null
            private set

        val context: Context
            get() = instance!!.applicationContext
    }

    /** A tree which logs important information for crash reporting.  */
//    private class CrashReportingTree : Timber.Tree() {
//        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
//            Crashlytics.log(priority, tag, message)
//            t.let { Crashlytics.logException(it) }
//        }
//    }
}

//fun logStackTrace(tag: String, throwable: Throwable?) {
//    if (throwable != null) {
//        Timber.tag(tag).e(throwable.toString())
//        for (stackTraceElement in throwable.stackTrace) {
//            Timber.tag(tag).e("  at: ${stackTraceElement.className} ${stackTraceElement.methodName} (${stackTraceElement.fileName}:${stackTraceElement.lineNumber})")
//        }
//    }
//}

