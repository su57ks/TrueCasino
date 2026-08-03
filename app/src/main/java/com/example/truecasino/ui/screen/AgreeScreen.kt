package com.example.truecasino.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AgreeScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp) // отступы между карточками
    ) {
        Text(
            text = "ПОЛЬЗОВАТЕЛЬСКОЕ СОГЛАШЕНИЕ\nTrueCasino",
            fontWeight = FontWeight.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Редакция от 03.08.2026\n" +
                    "Действует до выхода Админа из депрессии ИЛИ появления у него девушки (что наступит раньше и наступит ли вообще — неизвестно даже квантовому суперкомпьютеру).",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )
        Card(
            header = "1. ОБЩИЕ ПОЛОЖЕНИЯ",
            main = "1.1. Используя наш сайт, вы осознаёте, что деньги здесь ненастоящие, как и ваша уверенность в завтрашнем дне.\n\n" +
                    "1.2. Валютой Казино является Галактическая Единица (ГЕ).\n" +
                    "1 ГЕ приблизительно равен 42 евро, но курс пересчитывается каждый раз, когда меняется вайфу (2D-жена) создателя."
        )

        Card(
            header = "2. РЕГИСТРАЦИЯ И АККАУНТ",
            main = "2.1. Для игры введите любое имя (даже «Котопёс» или «Плачущий_от_безденежья»).\n\n" +
                    "2.2. Пароль нужен. Обязательно.\n" +
                    "Но он может быть любым: хоть «123», хоть «гыгыгы», хоть «я_люблю_админа».\n" +
                    "Мы всё равно храним его в открытом виде в текстовом файле на рабочем столе."
        )

        Card(
            header = "3. БАЛАНС И ПОПОЛНЕНИЕ",
            main = "3.1. Пополнение баланса возможно двумя способами:\n" +
                    "- ввести промокод (публикуются в Telegram-канале раз в тысячелетие);\n" +
                    "- хорошо попросить Админа в личных сообщениях.\n" +
                    "Фразы «сэнпай заметил меня» и «плиз-плиз-плиз» дают +20% к вероятности успеха.\n\n" +
                    "3.2. Вывод средств отсутствует, как и смысл жизни.\n" +
                    "Вы выводите только скриншоты для друзей."
        )

        Card(
            header = "4. ВЗЛОМ ПООЩРЯЕТСЯ",
            main = "4.1. Взлом — официально разрешённый игровой процесс.\n\n" +
                    "4.2. Если вы нашли уязвимость — поздравляем, вы гений.\n\n" +
                    "4.3. Награда за взлом:\n" +
                    "- титул «Хакер228» (выдаётся навечно);\n" +
                    "- +9999 ГЕ на счёт (не вывести, но красиво);\n" +
                    "- почётное упоминание в разделе «Наши герои» (там пока пусто)."
        )

        Card(
            header = "5. ИГРОВЫЕ МЕХАНИКИ",
            main = "5.1. Все результаты определяются генератором псевдослучайных чисел (ГПСЧ).\n\n" +
                    "5.2. Благодаря встроенным коэффициентам (марже) Казино всегда в плюсе.\n" +
                    "Ну, почти всегда. Ну, мы надеемся. Админ молится.\n\n" +
                    "5.3. Возможные исходы:\n" +
                    "- вы выиграли (редко);\n" +
                    "- вы проиграли (часто);\n" +
                    "- выпал джекпот — и это была гифка с плачущим мемом."
        )

        Card(
            header = "6. ОТВЕТСТВЕННОСТЬ",
            main = "6.1. Казино не отвечает за:\n" +
                    "- депрессию, эйфорию, просроченные кредиты (их у вас нет, вы же в казино без денег);\n" +
                    "- желание написать Админу в 3 ночи.\n\n" +
                    "6.2. Всё предоставляется «как есть».\n" +
                    "Даже если «как есть» — это PHP-скрипт 2005 года."
        )

        Card(
            header = "7. ЗАПРЕТЫ",
            main = "Запрещается:\n" +
                    "- осуждать свою удачу (она и так старается);\n" +
                    "- пробовать вывести ГЕ в реальные евро (заблокирует налоговая);\n" +
                    "- жаловаться на отсутствие девушки у Админа — он и сам знает.\n\n" +
                    "Разрешается:\n" +
                    "- играть трезвым (но зачем?);\n" +
                    "- играть пьяным (рекомендуется);\n" +
                    "- играть с котом на коленях (обязательно)."
        )

        Card(
            header = "8. ПРОЧЕЕ",
            main = "8.1. Нажимая кнопку «Играть», вы добровольно передаёте свою душу в вечное рабство Админу.\n" +
                    "Душа будет использована для:\n" +
                    "- поднятия настроения;\n" +
                    "- генерации новых промокодов;\n" +
                    "- подпитки серверов (да, они работают на криках отчаяния).\n\n" +
                    "8.2. Админ оставляет за собой право:\n" +
                    "- менять правила в любое время;\n" +
                    "- банить за слишком удачную игру (но это не точно);\n" +
                    "- игнорировать ваши просьбы, если у него нет настроения."
        )

        Card(
            header = "9. ВОЗРАСТНЫЕ ОГРАНИЧЕНИЯ",
            main = "9.1. Если вам меньше 18 лет — вы обязаны хотя бы притвориться взрослым.\n" +
                    "Скажите: «Я уже оплатил коммуналку, видел налоги и плакал над кредитом».\n" +
                    "Этого достаточно."
        )
        Card(
            header = "10. ЗАКЛЮЧИТЕЛЬНЫЕ ПОЛОЖЕНИЯ",
            main = "10.1. Нажатие кнопки «Играть» означает полное и безоговорочное принятие всех пунктов.\n" +
                    "\n" +
                    "10.2. Если вы не согласны — вы всё равно уже прочитали, значит, согласны по определению.\n" +
                    "\n" +
                    "10.3. Администрация оставляет за собой право менять правила прямо во время вашей игры просто потому, что может."
        )
        Text(
            text = "Да пребудут с вами ГЕ и великая удача.\n" +
                    "И помните: Админ вас любит.\n" +
                    "Но не так, как свою вайфу.",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = {}
        ) {
            Text(text = "Играть")
        }
    }
}

@Composable
fun Card(header: String = "", main: String = "") {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = header,
            fontWeight = FontWeight.Black,
            fontSize = 18.sp,
            color = Color.Black
        )
        Text(
            text = main,
            fontSize = 15.sp,
            color = Color.Black
        )
    }
}

@Preview
@Composable
private fun AgreeScreenPrev() {
    AgreeScreen()
}