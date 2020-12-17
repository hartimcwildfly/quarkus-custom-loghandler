
# Quarkus Logging MyLog extension

This is needed for using mylog handler(s) in Quarkus.
Curently only named handlers work.

tested example yaml config:

    quarkus:
      log:
        category:
          "\"io.quarkus\"":
            level: ALL
            handlers: "handler1"

      handler:
        mylog:
          "handler1":
            level: ALL
            filename: localhost.log
            local-dir: /tmp
            port: 1050
            standalone: false
