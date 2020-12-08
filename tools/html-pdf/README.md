## 导包

在 build.gradle 中：

```groovy
dependencies {

    compile group: 'com.itextpdf.tool', name: 'xmlworker', version: '5.5.13.2'
    compile group: 'com.itextpdf', name: 'itextpdf', version: '5.3.4';
    compile group: 'org.freemarker', name: 'freemarker', version: '2.3.30'

}
```



## 字段介绍

```java
private static final String FONT = "simhei.ttf";
```

iText 默认不支持中文的，需要添加对应的中文字体,比如黑体simhei.ttf 

在 springBoot 中，将 simhei.ttf 放到 resources 下



```java
private static final String HTML = "./src/main/resources/template.html";

```

HTML  则是 html 模板存放的位置



```java
private static final String DEST = "./HelloWorld_CN_HTML2.pdf";
```

DEST 是要将生成的 pdf 文件存放的位置



参考文章：https://www.cnblogs.com/achengmu/p/10790789.html