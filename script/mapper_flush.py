#encoding:utf-8
import pymysql
import os
import config

def flush(row):
	if os.path.isfile('../src/main/resources/generatorConfig.xml'):
		os.remove("../src/main/resources/generatorConfig.xml")
	infile = open("generatorConfig.xml","r")
	outfile = open("../src/main/resources/generatorConfig.xml", "a") # 内容输出
	configLines = infile.readlines()
	#print configLines
	for configLine in configLines:
		outfile.write(configLine.replace("${table}", row[0].strip()).replace("${db}", config.database.strip()).replace("${user}", config.user.strip()).replace('${pwd}', config.pwd.strip()).replace("${pkg}", row[0].strip()[2:]).replace("${className}", row[0].strip()[2:].capitalize()).replace("${url}", config.url.strip()))
	infile.close()    #文件关闭
	outfile.close()

def build():
	os.chdir("../")   
	os.system('mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate')
	os.chdir("./script")
	if os.path.isfile('../src/main/resources/generatorConfig.xml'):
		os.remove("../src/main/resources/generatorConfig.xml")

def initDbConfig():
	file = open("../config/server.properties","r")
	lines = file.readlines()
	for line in lines:

		if line.split(':',1)[0] == "druid.user":
			config.user = line.split(':',1)[1]
		if line.split(':',1)[0] == "druid.password":
			config.pwd = line.split(':',1)[1]
		if line.split(':',1)[0] == "druid.url":
			count= line.split(':',1)[1].find("?")
			config.url = line.split(':',1)[1][14:count]
			config.database=config.url.split("/")[1]
			config.url=config.url.split(":")[0]
	file.close()
	return ""


def start():
	initDbConfig()
	# print config.url
	# print config.user
	# print config.pwd
	# print config.database
	db = pymysql.connect(config.url.strip(),config.user.strip(),config.pwd.strip(),config.database.strip())
	cursor = db.cursor()
	cursor.execute("show tables")
	ret = cursor.fetchall()
	#print ret
	for row in ret:
		print row
		flush(row)
		build()
	db.close()
	

if __name__ == '__main__':
	start()

