转载自https://www.linuxprobe.com/linuxcommands-for-software.html

## 1.日志查看
实时查看tomcat日志文件查看：  
`cd /home/tomcat/logs` #也可用相对目录 `tail –f catalina.out` #实时打印日志文件 `ctrl+c` #退出查看
查看日志命令：
```shell script
tail -f log.txt：循环查看
tai -500f log.txt:查看最后500行
cat file：查看短文件
less file：查看长文件
head example.txt ：显示文件 example.txt 的前十行内容 head -n 20 example.txt：显示文件 example.txt 的前二十行内容
```
## 2.修改配置文件内容
最常见的就是修改环境变量
vim /etc/profile输入字母i， 进入编辑模式 输入内容，按esc，进入命令模式 。 执行:wq，保持修改。 输入 soucre /etc/profile 使环境变量生效。 可以通过 cat /etc/profile查看文件是否修改成功。
插入模式:底部有“--INSERT--”标记，完成文本的编辑功能。
i：在当前光标前插入文本；
a：在当前光标后添加文本；
o：在当前光标下一行插入文本；
命令模式:刚进入的状态，可以实现光标的移动以及字符的删除、复制、粘贴等。
x：删除字符 dw/dd：删除词/删除行 yw/yy:复制词，复制行 P：粘贴 kjhl：上下左右 ctrl+f/b:翻页
底线模式：命令模式下输入冒号进入，可设置行号、查找、替换字符、保存退出等。
set nu/nonu:设置行号 w filename：保存文件 wq：保存退出 q！：强制退出，不保存。 edit:在vi里打开另一文件。

## 4.查看tomcat进程，杀死进程，重启进程
查看tomcat进程 ps -ef/grep tomcat ps –aux/grep tomcat 杀死进程 kill -9 进程ID ps -ef/grep tomcat#查看进程是否已关闭 进入tomcat的bin目录cd /usr/local/tomcat/bin 启动tomcat ./startup.sh

## 5.压缩解压缩文件
tar cvf a.tar 1.txt 2.txt 3.txt#将3个文件放到文件包a.tar中。 tar cvf /tmp/a1.tar *.txt#指定包存放的位置。 tar xvf a.tar#将文件解压缩到当前目录。 tar -zcvf a.tar.gz *.txt#打包与压缩为a.tar.gz。 tar -zxvf a.tar.gz#解压缩并解包。
参数说明
-c: 建立压缩档案 -x：解压 -t：查看内容 -r：向压缩归档文件末尾追加文件 -u：更新原压缩包中的文件 -z：有gzip属性的 -j：有bz2属性的 -Z：有compress属性的 -v：显示所有过程 -O：将文件解开到标准输出

## 6.上传/下载
在xshell中可以通过下面的命令进行上传下载：
一般般需要安装，可使用 yum install lrzsz
rz：选择上传文件
sz 文件名：选择下载路径
当然你也可以通过xftp工具，进行可视化的上传下载

## 7.文件查找
find：实时查找，通过遍历指定起始路径下文件系统层级结构，根据文件的属性进行查找，如文件名，文件大小，所有者，所属组，是否为空，访问时间，修改时间。
格式：
```shell script
find ...
```

结合通配符和管道命令有如下示例：
find /etc -name \*****.txt** **：在/etc目录下，查找以.txt结尾的文件，给出所有文件的路径。** **find /etc -name '\*abc\*'：在/etc目录下查找文件名中含有字符串‘abc’的文件。** **find / -amin -5:查找在系统中最后5分钟访问的文件。** **find / -mmin -5：查找在系统中最后5分钟里修改过的文件。** **find / -size -1000k：查找出小于1000KB的文件。** **find /etc / grep local 在/etc目录下查找含有local这几个字母的所有文件或者目录

## 8.移动、复制命令
移动当前目录文件夹AA 到/home/aa/
`mv AA/ /home/aa/`
移动当前目录文件a.txt到 /home/aa/目录，并重命名为b.txt
`mv a.txt /home/aa/b.txt`
复制当前目录文件a.txt到/home/B目录
`cp a.txt /home/B`
复制文件夹 AA到/home/B目录
`cp -r AA/ /home/B`

跨服务器复制：scp
命令格式： scp
从远处复制文件到本地目录 scp root@192.168.1.204:/home/soft/tomcat.tar.gz /home/test/ 上传本地文件到远程机器指定目录 scp /home/test/nginx-0.5.38.tar.gz root@192.168.1.204:/opt/soft/

## 9.权限修改
通过ls -l命令，可查看文件的相关属性。
ls -l
第一个字符：- d l
第二到第九位是文件的所属权限。
Linux文件的权限分为4种：
read write execute none
9位分成3组：
第一组代表这个文件的所有者owner有什么权限
第二组代表这个文件的所有组group的人所拥有的权限
第三组代表其他人others具有什么权限
修改文件访问权限：
chmod who +/- r/w/x file
chmod u+x file 只给自己加上可执行权限
chmod ug+x file 所有者和所属组加上可执行权限
chmod u-x file 用户取消可执行权限
在Linux内部表示权限，是用3个二进制数来表示的
比如000 ：0 111：7
所以r=4，w=2，x=1
7表示权限都齐了 5表示没有写的权限
假设owner：rwx，group：r-x，other：r-x
则权限设置为：chmod 755 file

## 10. 服务器性能监控
监控CPU、内存
top：类似于windows的任务管理器，能够实时监控系统的运行状态，主要显示系统中各个进程的资源使用情况，如cpu、内存、负载等。
ps aux | grep dmc   查看容器对应的进程
top -p 33965 -d 2 -b  >> collector_cpu.log
free：查看服务器内存使用情况，包括物理内存、交换内存和内核缓冲区内存的空闲和剩余统计。
实际内存指的是jvm
jps
jstat -gccause 8 6000 20

arthas监控耗时方法
trace 类名 方法名  -n 3

