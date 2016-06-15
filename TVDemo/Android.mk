#ifeq "$(ANDROID_TWO_WORLDS)" "true"
LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_STATIC_JAVA_LIBRARIES := android-support-v7-recyclerview android-support-v13 android-support-v17-leanback volley	\
			android-support-v7-appcompat

LOCAL_RESOURCE_DIR := \
    $(TOP)/frameworks/support/v17/leanback/res \
    $(TOP)/frameworks/support/v7/appcompat/res \
    $(LOCAL_PATH)/res

LOCAL_AAPT_FLAGS := --auto-add-overlay --extra-packages android.support.v17.leanback
# =================================================
#prepare source code

LOCAL_SRC_FILES := \
        $(call all-java-files-under, java)

# =================================================


LOCAL_PACKAGE_NAME := TVDemo
#LOCAL_CERTIFICATE := platform
LOCAL_PRIVILEGED_MODULE := true
#LOCAL_OVERRIDES_PACKAGES := Home
LOCAL_PROGUARD_FLAG_FILES := proguard.flags

include $(BUILD_PACKAGE)

