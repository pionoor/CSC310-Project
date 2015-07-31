DROP DATABASE `ambago-db1`;
create DATABASE `ambago-db1`;
use ambago-db1;
SOURCE ~/insertion_scripts/createTable.sql;
SOURCE ~/insertion_scripts/realData.sql;
SOURCE ~/insertion_scripts/insertSyntheticData.sql;