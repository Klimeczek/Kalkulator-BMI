# Obserwacje dotyczące AndroidManifest.xml
## Co sie stało po usunięciu <intent-filter>?
Po usunięciu bloku `<intent-filter>` aplikacja **zniknęła z ekranu głównego** (nie było widać jej ikony) i nie dało się jej normalnie uruchomić z listy aplikacji.
## Dlaczego tak się stało?
Bez tego filtra system Android nie wie, którą aktywność ma uruchomić po kliknięciu ikony, dlatego aplikacja przestaje być widoczna na launcherze.