<img src="https://raw.githubusercontent.com/benchdoos/JColorful/master/public/ico128.png" align="right" width="128" />

Library in development.

If you want to contribute - contact me.

Code example:
```
JColorful colorful = new JColorful(DefaultThemes.EXTREMELY_BLACK); //you can use default or create own one
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
      "foreground": "#eeeeee"
    },
    {
      "objectType": "JProgressBar",
      "background": "#333333"
    }
  ]
}
```
JSON theme file v.1 is still in development. Maybe some new features will be added to v.1.

After release will be created v.2 to add some new features.

Library should work like this:

before:
<img src="/public/white.jpg" align="right" width="888" />

after
<img src="/public/dark.jpg" align="right" width="888" />
