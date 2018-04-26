# language: ru
  Функционал: аутентификация в автоматизированную систему учета активов

    Предыстория:
#      Дано открыт браузер и осуществлен переход по ссылке
      И открывается страница с формой "Вход в систему"

    @11111
    Структура сценария: аутентификация с валидными данными
      Когда пользователь заполняет поле "Имя пользователя" значением "<логин>"
      И пользователь вводит в поле "Пароль" значением "<пароль>"
      И пользователь нажимает кнопку "Войти"
      Тогда открывается модальное окно "Выбор финансовой организации"
      Тогда пользователь выбирает финансовую организацию "10" типа КО
      И пользователь нажимает кнопку "Выбрать"
      Тогда откывается страница с логотипом "Агентство по страхованию вкладов"
      Тогда открывается страница с финансовой организацией "10"
      И пользователь нажимает кнопку "Права  Все"
      И пользователь нажимает кнопку "Выход" в контекстном меню
#      И браузер закрыт
      Примеры:
      | логин   | пароль    |
      | sua_all | Q1w2e3r4  |

    @11112
    Сценарий: аутентификация с невалидными данными
      Когда пользователь заполняет поля "Имя пользователя" и "Пароль" значениями
      | sua_all1 |  Q1w2e3r41 |
      И пользователь нажимает кнопку "Войти"
      Тогда открывается страница с сообщением "Неверное имя пользователя или пароль."
#      И браузер закрыт