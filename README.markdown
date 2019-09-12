# PlayCore API sample

This repo has been migrated to [github.com/android/app-bundle][1]. Please check that repo for future updates. Thank you!

[1]: https://github.com/android/app-bundle


> Logcat tag : LOG_TAG
```
LOG_TAG: MainApplication before createConfigurationContext android.content.res.AssetManager@321072d [zh_CN_#Hans]
LOG_TAG: MainApplication after createConfigurationContext android.content.res.AssetManager@f0df462 [en]
LOG_TAG: BaseSplitActivity before createConfigurationContext android.content.res.AssetManager@a15d46b [zh_CN_#Hans]
LOG_TAG: BaseSplitActivity after createConfigurationContext android.content.res.AssetManager@7c63bc8 [en]

// caused by webview create
LOG_TAG: MainActivity beforeCreateWebView android.content.res.AssetManager@7c63bc8 [en]
LOG_TAG: MainActivity afterCreateWebView android.content.res.AssetManager@6b09538 [en]
```