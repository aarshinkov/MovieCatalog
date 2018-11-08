CREATE OR REPLACE PACKAGE MOVIECAT_GENERAL IS

  ---------- insert_user ----------
  PROCEDURE insert_user(ip_username IN NVARCHAR2,
                        ip_name     IN NVARCHAR2,
                        ip_password IN NVARCHAR2,
                        ip_email    IN NVARCHAR2);
END MOVIECAT_GENERAL;
/
CREATE OR REPLACE PACKAGE BODY MOVIECAT_GENERAL IS

  ---------- insert_user ----------
  PROCEDURE insert_user(ip_username IN NVARCHAR2,
                        ip_name     IN NVARCHAR2,
                        ip_password IN NVARCHAR2,
                        ip_email    IN NVARCHAR2) IS
  BEGIN
    INSERT INTO USERS
    VALUES
      (S_USERS.NEXTVAL, ip_username, ip_name, ip_password,
       ip_email);
  END;
END MOVIECAT_GENERAL;
/
