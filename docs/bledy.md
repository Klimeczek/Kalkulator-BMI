# Obserwacje z celowego psucia aplikacji
## `findViewById` z nieistniejacym id:
Zmiana id w `activity_main.xml` z `"@+id/etHeight"` w `"@+id/etWzrost"` (linia: 21)
---------------------------- PROCESS STARTED (15129) for package com.example.kalkulatorbmi ----------------------------
2026-09-20 01:39:27.006 15129-15129 AndroidRuntime          com.example.kalkulatorbmi            D  Shutting down VM
2026-09-20 01:39:27.007 15129-15129 AndroidRuntime          com.example.kalkulatorbmi            E  FATAL EXCEPTION: main
Process: com.example.kalkulatorbmi, PID: 15129
java.lang.NullPointerException: Attempt to invoke virtual method 'android.text.Editable android.widget.EditText.getText()' on a null object reference

## `findViewById` przed `setContentView`:
---------------------------- PROCESS STARTED (16529) for package com.example.kalkulatorbmi ----------------------------
2026-09-20 01:41:40.261 16529-16529 AndroidRuntime          com.example.kalkulatorbmi            D  Shutting down VM
2026-09-20 01:41:40.262 16529-16529 AndroidRuntime          com.example.kalkulatorbmi            E  FATAL EXCEPTION: main
Process: com.example.kalkulatorbmi, PID: 16529
java.lang.NullPointerException: Attempt to invoke virtual method 'android.text.Editable android.widget.EditText.getText()' on a null object reference

## `Toast` bez `.show()`:
Aplikacja działa prawie tak samo jak przed zmianą. Jedyną różnicą jest brak okienka z powiadomieniem o błędnie wprowadzonych danych.