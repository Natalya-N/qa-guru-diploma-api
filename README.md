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
Перейти по [ссылке](https://jenkins.autotests.cloud/job/C32-nechaevanatalya-diploma-api/)

Для запуска сборки необходимо кликнуть на "Build with parameters"

<img width="1419" alt="Снимок экрана 2025-03-08 в 16 11 55" src="https://github.com/user-attachments/assets/b80106e8-612a-4334-a594-a9832857f550" />


## :label: Параметры сборки в Jenkins:
browser (браузер, по умолчанию chrome)  
browserVersion (версия браузера, по умолчанию 122)  
browserSize (размер окна браузера, по умолчанию 1920x1080)

## :bar_chart: Пример Allure отчета:

Для просмотра перейти по [ссылке]()

<img width="1421" alt="Снимок экрана 2025-03-09 в 23 11 52" src="https://github.com/user-attachments/assets/ef77a9b0-84c7-4436-bff5-082381601c56" />


Результат выполнения тестов:
<img width="1435" alt="Снимок экрана 2025-03-09 в 23 12 14" src="https://github.com/user-attachments/assets/cb387226-2ab7-44bd-994e-1b89f89bb961" />


## :bell: Уведомления в Telegram с использованием бота:
После завершения сборки Telegram-бот автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов

<img width="436" alt="Снимок экрана 2025-03-09 в 23 10 04" src="https://github.com/user-attachments/assets/49f9405e-51bb-4f47-bc6f-006ccddcbeca" />