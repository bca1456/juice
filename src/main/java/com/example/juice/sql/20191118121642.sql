/*
PostgreSQL Backup
Database: juice/public
Backup Time: 2019-11-18 12:16:42
*/

DROP SEQUENCE IF EXISTS "public"."hibernate_sequence";
DROP TABLE IF EXISTS "public"."books";
DROP TABLE IF EXISTS "public"."cars";
DROP TABLE IF EXISTS "public"."user_role";
DROP TABLE IF EXISTS "public"."usr";
CREATE SEQUENCE "hibernate_sequence" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
CREATE TABLE "books" (
  "id" int4 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "books" OWNER TO "postgres";
CREATE TABLE "cars" (
  "id" int4 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "mileage" int4,
  "drive_unit" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "cars" OWNER TO "postgres";
CREATE TABLE "user_role" (
  "user_id" int8 NOT NULL,
  "roles" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "user_role" OWNER TO "postgres";
CREATE TABLE "usr" (
  "id" int8 NOT NULL,
  "active" bool NOT NULL,
  "password" varchar(255) COLLATE "pg_catalog"."default",
  "username" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "usr" OWNER TO "postgres";
BEGIN;
LOCK TABLE "public"."books" IN SHARE MODE;
DELETE FROM "public"."books";
INSERT INTO "public"."books" ("id","name") VALUES (147, 'aaaa@s.a'),(148, 'a'),(26, 'harry potter'),(149, 'a'),(150, '777'),(66, 'sdfsdfsd'),(73, 'asds'),(77, 'sss'),(136, 'as'),(137, 'aa'),(138, '666'),(139, 'asdыs'),(140, 'kek tut da');
COMMIT;
BEGIN;
LOCK TABLE "public"."cars" IN SHARE MODE;
DELETE FROM "public"."cars";
INSERT INTO "public"."cars" ("id","name","mileage","drive_unit") VALUES (1, 'audi', 20000, 'front'),(2, 'bmw', 1500000, '4wd');
COMMIT;
BEGIN;
LOCK TABLE "public"."user_role" IN SHARE MODE;
DELETE FROM "public"."user_role";
INSERT INTO "public"."user_role" ("user_id","roles") VALUES (27, 'USER'),(28, 'USER'),(29, 'USER'),(41, 'USER'),(42, 'USER');
COMMIT;
BEGIN;
LOCK TABLE "public"."usr" IN SHARE MODE;
DELETE FROM "public"."usr";
INSERT INTO "public"."usr" ("id","active","password","username") VALUES (27, 't', '1', 'u'),(28, 't', '2', 'q'),(29, 't', '3', 'w'),(1, 't', '32', 'qw'),(41, 't', '5', 'y'),(42, 't', 'g', 'g');
COMMIT;
ALTER TABLE "books" ADD CONSTRAINT "books_pkey" PRIMARY KEY ("id");
ALTER TABLE "cars" ADD CONSTRAINT "cars_pkey" PRIMARY KEY ("id");
ALTER TABLE "usr" ADD CONSTRAINT "usr_pkey" PRIMARY KEY ("id");
ALTER TABLE "user_role" ADD CONSTRAINT "fkfpm8swft53ulq2hl11yplpr5" FOREIGN KEY ("user_id") REFERENCES "public"."usr" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
SELECT setval('"hibernate_sequence"', 151, true);
ALTER SEQUENCE "hibernate_sequence" OWNER TO "postgres";
