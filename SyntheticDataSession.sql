DROP DATABASE `ambago-db1`;
create DATABASE `ambago-db1`;
use ambago-db1;
SOURCE ~/createTable.sql;
SOURCE ~/insertSyntheticData.sql;
SOURCE ~/selectSyntheticData.sql;