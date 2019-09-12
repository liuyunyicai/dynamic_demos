package com.google.android.samples.dynamicfeatures.test

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.Log

/**
 * @author: Created By nealkyliu
 * @date: 2019-09-05
 */
object ResourcesHookHelper {
    val ResourceImplClass = forName("android.content.res.ResourcesImpl")

    fun init() {

    }

    fun forName(className: String): Class<*>? {
        try {
            return Class.forName(className)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }

        return null
    }

    @Throws(NoSuchFieldException::class)
    fun getFiledValue(clazz: Class<*>, filedName: String, obj : Any? = null): Any {
        return clazz.getDeclaredField(filedName).let {
            it.isAccessible = true
            it.get(obj)
        }
    }

    fun invokeSimpleMethod(clazz: Class<*>, methodName : String, obj : Any? = null) : Any? {
        return clazz.getDeclaredMethod(methodName).let {
            it.isAccessible = true
            it.invoke(obj)
        }
    }

    fun getmResourceImpls() : Any? {
        return forName("android.app.ResourcesManager")?.let { resManagerClass ->
            val resManagerObj = invokeSimpleMethod(resManagerClass, "getInstance")
            getFiledValue(resManagerClass, "mResourceImpls", resManagerObj)
        }
    }

    fun getAssetFieldFromResourcesImpl(obj : Any) : Any? {
        return ResourceImplClass?.let {
            getFiledValue(it, "mAssets", obj)
        }
    }

    fun getmResourcesImplFromResources(obj : Any?) : Any? {
        return getFiledValue(Resources::class.java, "mResourcesImpl", obj)
    }

    fun logAssetInfo(message : String, context: Context?) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            return
        }

        context?.apply {
            val logTag = message

            log("$logTag ${context.assets} [${context.resources?.configuration?.locale}]")
//            log("$logTag ${getmResourcesImplFromResources(context.resources)}")
        }
    }

    fun log(message: String) {
        Log.d("LOG_TAG", message)
    }
}

