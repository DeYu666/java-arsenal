## html-pdf

将 html 模板转成 pdf

参考文章：https://www.cnblogs.com/achengmu/p/10790789.html



## Base64ImageUtils.java

图片和 Base64 字符串相互转化的类，提供了三个方法：

- `ImageToBase64ByLocal(String imgFile)` 传入图片的本地路径，将图片 base64 编码后，返回字节数组字符串
- `ImageToBase64ByOnline(String imgURL)`  传入图片的url 地址，将图片 base64 编码后，返回字节数组字符串
- `Base64ToImage(String imgStr, String imgFilePath)` 传入 base64 字符串 和 图片存放路径，通过此方法将 base64 字符串转换成图片



## DownloadService.java

通过浏览器下载服务器上指定的文件

其中 rootpath 是 WebRoot/uploadFile 中，大概就是 tomcat 服务器的临时文件夹。

通过传入的 filename ，将 rootpath 文件下的 filename 文件进行下载

## RadarMap.java
用 java 的 Graphics2D 类 画六维图（雷达图）
![六维图](https://github.com/DeYu666/java-arsenal/blob/b2266732007b36a7a3cbd74a273ac514ae4f6451/tools/img/radar.png)
