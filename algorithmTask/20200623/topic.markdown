## z字形变换
将一个给定字符串根据给定的行数，以从上往下、从左到右进行z字形排列

比如输入字符串为“LEETCODEISSHRING”，行数为3，排列如下：
```
L   C   I   R
E T O E S I I G
E   D   H   N
```

之后，你的输入需要从左到右逐行读取，产生新的字符串，如“LCIRETOESIIGEDHN”

请你实现这个将字符串进行指定行数变换的函数
`string convert(string s, int numRows)`

示例1：
```
输入： s="LEETCODEISHIRING", numRows=3
输出："LCIRETOESIIGEDHN"
```

示例2：
```
输入： s="LEETCODEISHIRING", numRows=4
输出： "LDREOEIIECIHNTSG"
解释：
L     D     R
E   O E   I I
E C   I H   N
T     S     G
```

解决方案：
根据numRows分成几组StringBuilder，填完再合并