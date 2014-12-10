(ns guestbook.models.db
(:require [clojure.java.jdbc :as sql]) (:import java.sql.DriverManager))

(def db {:classname "org.sqlite.JDBC", :subprotocol "sqlite",
:subname "db.sq3"})
