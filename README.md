# TestSQLiteDB
Tutorial how to use the SQLite in an Android app. The code uses the raw SQL to create, drop and select data from the databases. This method is harder to manage than the Android wrapper API that helps you so do the same basic CRUD operations but much easier.

```java
Cursor cur = dbCon.rawQuery("SELECT name FROM pets", null);
cur.moveToFirst();
String nome = cur.getString(0);
```

The equivalent of

```java
Cursor c = sqLiteDatabase.query("pets", tableColumns, whereClause, whereArgs,
        null, null, orderBy);
int nome = c.getString(0);
```
