<img src="https://raw.githubusercontent.com/benchdoos/JColorful/master/public/ico128.png" align="right" width="128" />

If you want to contribute - contact me.

To import to a maven project add to `dependencies` section:

```
<dependency>
  <groupId>com.github.benchdoos</groupId>
  <artifactId>JColorful</artifactId>
  <version>1.0.2</version>
</dependency>
```

Code example:
```
JColorful colorful = new JColorful(JColorful.EXTREMELY_BLACK); //you can use default or create own one
TestWindow testWindow = new TestWindow();
colorful.colorize(testWindow); // any Component
testWindow.setVisible(true);

```

Simple theme example (section "common" is required):
```
{
  "type": "jColorfulTheme",
  "version": 1,
  "theme": [
    {
      "objectType": "common",
      "background": "#333333",
      "foreground": "#eeeeee"
    },
    {
      "objectType": "JButton",
      "background": "#414141",
      "foreground": "#BFBFBF"
    },
    {
      "objectType": "JTextComponent",
      "background": "#333333",
      "foreground": "#ffffff",
      "caret": "#ffffff",
      "selection": "#9F9F9F"
     }
  ]
}
```

**For more information visit [wiki](https://github.com/benchdoos/JColorful/wiki)**

Library should work like this:

before:
<img src="/public/white.gif" align="right" width="888" />

after
<img src="/public/dark.gif" align="right" width="888" />
