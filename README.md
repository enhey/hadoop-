friends.txt中数据A:B,C,D,F,E,O为A拥有B,C,D,F,E,O等好友
先执行FirDriver，将拥有A好友的人放在一起（A，好友列），拥有B为好友的人也放在一起（B，好友列）。。。

result/part-r-00000中的数据A	I,K,C,B,G,F,H,O,D,点意思为好友列表中有A的人有I,K,C,B,G,F,H,O,D
执行SecDriver,把拥有A好友的人组合一下，排列出的这些人代表都拥有A好友
map执行I-K A；I-C A；I-B A。。。。
reduce统计最后结果

执行操作前删除result和end_result文件夹
