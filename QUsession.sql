--QUsession.sql

-- /* query the small DB */
tee ./log_files/queryLog.txt;
DROP DATABASE `ambago-db1`;
create DATABASE `ambago-db1`;
use ambago-db1;
SOURCE ~/insertion_scripts/createTable.sql;
SOURCE ~/insertion_scripts/realData.sql;
SOURCE ~/query.sql;

/* query the large DB */
DROP DATABASE `ambago-db1`;
create DATABASE `ambago-db1`;
use ambago-db1;
SOURCE ~/insertion_scripts/createTable.sql;
SOURCE ~/insertion_scripts/realData.sql;
SOURCE ~/insertion_scripts/insertSyntheticData.sql;
SOURCE ~/query.sql;
notee;

/*update small DB*/
tee ./log_files/updateLog.txt;
DROP DATABASE `ambago-db1`;
create DATABASE `ambago-db1`;
use ambago-db1;
SOURCE ~/insertion_scripts/createTable.sql;
SOURCE ~/insertion_scripts/realData.sql;
SOURCE ~/update.sql;

/*update large DB*/
DROP DATABASE `ambago-db1`;
create DATABASE `ambago-db1`;
use ambago-db1;
SOURCE ~/insertion_scripts/createTable.sql;
SOURCE ~/insertion_scripts/realData.sql;
SOURCE ~/insertion_scripts/insertSyntheticData.sql;
SOURCE ~/update.sql;
notee;



