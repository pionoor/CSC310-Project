--SyntheticDataSession.sql
tee ./log_files/selectSyntheticDataLog.txt;
DROP DATABASE `ambago-db1`;
create DATABASE `ambago-db1`;
use ambago-db1;
SOURCE ~/insertion_scripts/createTable.sql;
SOURCE ~/insertion_scripts/insertSyntheticData.sql;
SOURCE ~/insertion_scripts/selectSyntheticData.sql;
notee;