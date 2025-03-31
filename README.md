# Демопроект по автоматизации тестирования для API [Литрес](https://www.litres.ru/)

> **Литрес** — сервис электронных и аудиокниг

## :page_facing_up: Содержание:
Технологии и инструменты  
Реализованные проверки  
Сборка в Jenkins  
Параметры сборки в Jenkins  
Пример Allure отчета  
Уведомления в Telegram с использованием бота

## :computer: Технологии и инструменты:
<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://telegram.org/"><img src="images/logo/Telegram.svg" width="50" height="50"  alt="Telegram"/></a>  
</p>


## :white_check_mark: Реализованные проверки:
Проверки получения профиля автора  
Проверки получения коллекций книг  
Проверка добавления книги в корзину  


## :arrow_forward: Сборка в Jenkins:
Перейти по [ссылке](https://jenkins.autotests.cloud/job/C32-nechaevanatalya-diploma--api/)

Для запуска сборки необходимо кликнуть на "Build with parameters"

<img width="1050" alt="Снимок экрана 2025-03-31 в 17 44 55" src="https://github.com/user-attachments/assets/6101ef00-1c38-4d4e-ba2e-1ab135d2cc96" />

## :bar_chart: Пример Allure отчета:

<img width="1282" alt="Снимок экрана 2025-03-31 в 17 47 49" src="https://github.com/user-attachments/assets/56669639-b75b-460c-9924-083a11f30090" />


Результат выполнения тестов:
<img width="1289" alt="Снимок экрана 2025-03-31 в 17 47 01" src="https://github.com/user-attachments/assets/3a159be9-c293-4ca6-940a-e906d5dfd7f9" />



## :bell: Уведомления в Telegram с использованием бота:
После завершения сборки Telegram-бот автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов

<img width="379" alt="Снимок экрана 2025-03-31 в 17 45 57" src="https://github.com/user-attachments/assets/ffc94357-63ba-44f0-a984-00f19915cff7" />
