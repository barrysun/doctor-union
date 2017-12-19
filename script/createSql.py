__author__ = 'barry'
# coding:utf-8

import xlrd
import re


data = xlrd.open_workbook("table.xlsx")
table = data.sheets()[0]

temp = table.row_values(0)[0]
tableName = re.findall("[a-zA-Z].*\w+", temp)[0]
nrows = table.nrows
#print nrows
sql = "create table " + tableName + "( \n"
for rownum in range(2, nrows):
    row = table.row_values(rownum)

    if row and rownum != (nrows - 1):

        if row[1] == "id":
            temp = float(row[3])
            sql += "`"+row[1] + "` " + row[2] + "(" + str(int(temp)) + ") " + "PRIMARY KEY,\n"
        else:
            sql += "`"+row[1] + "` "
            if re.search("DECI.*", row[2]):
                sql += " " + row[2]+""
            elif row[2] == "NUMBER" and row[3] == 8:
                sql += " int "
            elif row[2] == "NUMBER" and row[3] == 1:
                sql += " smallint "
            elif row[2] == "NUMBER" and row[3] > 10:
                sql += "bigint"
            elif row[2] == "DATETIME":
                sql += " timestamp "
            elif row[2] == "DATE":
                sql += " date "
            else:
                temp = float(row[3])
                sql += " " + row[2] + "(" + str(int(temp)) + ") "
            if row[4] == "Y" and row[5] == "Y":
                sql += " NOT NULL UNIQUE,\n"

            elif row[4] == "Y" and row[5] != "Y":
                sql += " NOT NULL,\n"
            elif row[4] != "Y" and row[5] != "Y":
                sql += ",\n"
    else:
        sql += "`"+row[1] + "` "

        if re.search("DECI.*", row[2]):
            sql += " " + row[2]
        else:
            temp = float(row[3])
            sql += " " + row[2] + "(" + str(int(temp)) + ") "

        if row[4] == "Y" and row[5] == "Y":
            sql += " NOT NULL UNIQUE,\n"

        elif row[4] == "Y" and row[5] != "Y":
            sql += " NOT NULL,\n"
        elif row[4] != "Y" and row[5] != "Y":
            sql += ",\n"
#if sql.
sql =sql.strip()
if len(sql)>0 and sql[-1:] == ",":
	sql = sql[0:-1]+"\n )"

print sql
