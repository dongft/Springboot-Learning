注意
    log4j.rootCategory=INFO, stdout, file, errorfile  的配置，
    此处的INFO即指定了日志输出级别，
    日志记录的优先级由高到低分为 :
    OFF ,FATAL ,ERROR ,WARN ,INFO, DEBUG, ALL。

    Log4j建议只使用FATAL ,ERROR ,WARN ,INFO ,DEBUG这五个级别。

    由于我们设置的是INFO,所以单元测试中，info跟error的日志输出有打印，但是debug的没有，要想打印debug的话，
    这里应该改为
        log4j.rootCategory=DEBUG, stdout, file, errorfile

解密Log4j、SLF4J、Common-logging的区别
    https://blog.csdn.net/chen3749102/article/details/52795786
