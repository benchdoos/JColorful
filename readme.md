Library in development.

If you want to contribute - contact me.

Code example:
```
JColorful colorful = new JColorful(DefaultThemes.EXTREMELY_BLACK);
TestWindow testWindow = new TestWindow();
colorful.colorize(testWindow); // any component
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
      "foreground": "#eeeeee",
      "border": {
        "type": "LineBorder",
        "color": "#333333"
      }
    },
    {
      "objectType": "JProgressBar",
      "background": "#333333"
    }
  ]
}
```

Library should work like this:

before:
<img src="/public/white.jpg" align="right" width="888" />

after:
<img src="/public/dark.jpg" align="right" width="888" />
