# * 使用`Kotlin Coroutine(协程)`和`Retrofit`建立`Demo`， *



本App一共2个界面

界面1：
显示三个城市（城市随意）的天气信息
接口示例：https://www.apiopen.top/weatherApi?city=重庆
说明：使用ViePager+TabLayout，每个tab标题显示城市，内容显示天气信息，适当排版

界面2：
显示一个列表，要求使用RecyclerView
接口示例：https://www.apiopen.top/satinApi?type=1&page=1
说明：列表的每个Item显示接口返回列表的一项信息，适当排版

要求：
- 1：使用 Android Studio 最新版本进行开发
- 2：使用Kotlin语言开发
- 3：使用任意网络框架
- 4：网络图片使用Glide加载
- 5：要求界面布局使用约束布局（ConstraintLayout）
- 6：要求使用5个productFlavor，用同一套逻辑代码生成5个applicationId不同的apk，对界面1的城市进行区分。
— 如：第一个apk，打开后界面1显示的三个城市是：北京、上海、广州；第二个apk，打开后界面1显示的三个城市是：成都、重庆、杭州；以此类推.并且要求5个apk中界面1的背景颜色不同（同样使用productFlavor的特性来区分）。
#：打包apk，并提交源代码