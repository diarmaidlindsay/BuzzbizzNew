package pulseanddecibels.jp.buzbiznew.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import pulseanddecibels.jp.buzbiznew.BuildConfig;
import pulseanddecibels.jp.buzbiznew.model.CallDirection;
import pulseanddecibels.jp.buzbiznew.model.CallState;
import pulseanddecibels.jp.buzbiznew.model.ContactDetailsListItem;
import pulseanddecibels.jp.buzbiznew.model.ContactListItem;
import pulseanddecibels.jp.buzbiznew.model.HistoryListItem;
import pulseanddecibels.jp.buzbiznew.model.HoldListItem;
import pulseanddecibels.jp.buzbiznew.model.TabTopContact;

/**
 * Created by Diarmaid Lindsay on 2016/04/13.
 * Copyright Pulse and Decibels 2016
 *
 * Supply Sample data during development
 */
public class SampleDataUtil {

    static final String[] SAMPLE_CONTACTS_JP = {"山本竜司","江田久","小出一郎","中野智則","藤本博之","渡辺隆史","吉見啓二","小林菜摘","榊祥","坂元毅","岩下誠司","井上真帆","加藤忍","渡邊晃一","豊田博之","山田航","中原秀一","金沢亮介","桑原智美","吉井菜穂子","前田薫","原田和正","井上真紀","吉岡晋","上野千春","脇田美佳","木村陽一","近藤亜美","瀬尾遥","野本雅史","加藤勇気","熊田奈月","亀井聡","森村洋平","原田彩","中村葉子","山本次郎","森沙織","加藤剛","福士将司","福地美紀","中村ゆう子","加藤貴久","山本彩","三木修","黒川綾","近藤彩","佐々木貴之","千葉麻子","井川遥","佐藤良子","相原佳奈","森麻帆","松本弘之","松本直人","徳川圭","松本孝夫","原竜也","細野孝一","田中亮太","吉田和真","葛西英二","中村直樹","草野巧","浅沼彰","石田春菜","北山信一","金山大輔","三宅祐二","小熊優花","沖杏奈","菊地宏和","飯山雅人","中村敏子","森本真琴","荒木恵","松野信子","堀内真弓","藤村健二","小川秀幸","大森純","川本桂子","多田美咲","荻野明日香","瀬川祐二","佐藤静香","佐野健太","妹尾耕二","原美紀","斉藤徹","田中健太","久保由実","岡田秀明","山本美里","藤田淳子","山田博","大野信","百田雅子","加藤亜希","伊吹啓介","一色直子","中村英治","原田優","橘家賢一","鈴木秀樹","田畑智子","福田朗","黒岩加奈","吉村剛","佐藤航平","柴山美沙子","佐藤典子","北原剛","石山直人","黒沢仁美","荒井正一","早坂優香","高橋優子","神田秀人","山田英雄","藤原翔平","栗原祐輝","矢野亨","内山美子","森岡仁美","相川由衣","服部法子","鈴木龍之介","堀江友美","立石光","植村潔","落合敦子","森脇雅子","石井葵","川上幸子","尾形悟","福元知哉","小沢周平","江口竜也","本田瑞希","加納春樹","馬場敬太郎","松下翔","土屋綾","片山美佳","小川梨絵","鈴木貴子","岡本英明","中川美和","椎名藍","大野久美","岩井勝男","近藤優子","河口正明","青木映子","磯部智恵子","平松朋子","会田真紀","小平卓也","丸山明","安井浩司","及川弘樹","佐藤杏奈","内山蘭","寺沢宏","菊地信一","高田研二","佐田和代","橋本真紀子","小林雅子","大西陽子","王浩二","秋元友里","吉木宏治","野田淳","加藤舞子","山田圭吾","北村真帆","青山浩司","中西亜希","田中護","大崎正","加藤京子","村上春樹","金田一夫","太田梢","山本梓","原浩美","中山義雄","小磯剛","稲葉真紀子","小林敬一","足立英二","香川美加","富田和美","宮内真実","松本香織","高橋大貴","相原有香","宮崎実","清水亜矢子","加藤美和","原明日香","石本凛","中村彩香","野崎伸二","石渡博行","井上幸子","林泉","柴田弓子","河合詩織","山下靖","佐藤次郎","中澤千春","川崎貴子","村山哲","中村真理","田口達也","一ノ瀬馨","中野誠","泉陽介","筒井美也子","平野由佳","石川明","星野奈々子","小林晶子","下川美樹","大久保真央","近藤崇","石橋弘美","真鍋太郎","西川哲也","星正","近藤俊彦","石井千春","黒木朋子","吉木祐介","井上薫","野本美穂","井上理沙","辻明久","大野泉","飯田道子","野田大樹","田中希","平塚恭子","伊藤雄介","小林茂","岩崎博","田中礼子","桜井涼介","大坪望","野中美穂","早坂夕子","橋本久子","伊藤譲二","小牧由紀","伊藤昇平","天野愛里","小林小百合","江口礼子","松下千夏","辻充","三浦猛","岩井龍之介","成田耕一","堀田理恵","岡村雄一","田原卓","杉田真理","相川稔","石川貴子","加藤優","松本信行","小田美奈子","松本大輔","小林真理","西本宏之","山崎昌子","神田真之介","髙橋博美","本間麻希","小泉曜子","森下卓也","岡崎直子","福本智也","河合光子","村田孝志","織田裕太","藤田美穂","平田正幸","武田祐司","入江浩司","坂上徹","服部茂","青山賢一","泉真理子","笠原公一","周彩","西村薫","斎藤れい子","中澤裕子","坂口智之","島田弥生","湯浅敬","山口忍","高山圭佑","狩野克彦","染谷里奈","早坂祐美子","島田直樹","大村秀人","岡崎晴香","赤井千秋","木村朗","岡山治","梶原亮太","安西桃子","西村直輝","今村優子","一条秀幸","川原健太","正木勝","早川祐介","坂田真由美","横田亜希","植草一朗","加藤毅","石田耕平","川田一義","星野秀子","本多耕二","河野愛","久野郁","吉田勲","大野貴弘","佐藤拓也","手塚静香","坂本隼人","津島大輔","大橋圭吾","大崎恵美","石橋玲奈","土岐美帆","稲垣信子","川本明","伴由美子","飯田夏樹","川上裕子","橋本琢也","浅香大介","太田達也","片平真琴","沖修","大槻樹里","渡邉隆司","土井一夫","塚原貴史","栗原譲","郡司大祐","二階堂信子","香月俊昭","栗原麻衣","宮本典子","安倍博子","甲斐まり子","橘瑠美","吉井敦史","桜井敦子","鏡信行","川原達夫","小磯康介","中島真紀","三浦健","吉川亜美","木下健二","野呂千尋","古澤竜二","北山光雄","松尾淳","鈴木妙子","畠山京子","安西瑞穂","柏原歩","亀井智","吉原勲","内藤輝彦","松田隆志","武藤徹","田中大輔","石川萌","安藤亜美","中村有希","夏目千晴","岡部浩","島智子","菊池慶太","後藤仁美","戸田伸幸","矢吹幸平","横山恭子","平野愛里","武井直子","孫裕子","秋元達郎","髙橋久子","工藤歩美","岡葉子","徳永菜穂子","佐々木優子","佐藤剛","筒井梨紗","伴晃子","長田亜紀","東彰","中井修一","川口恵美子","小林直樹","伊原真美","大嶋秀子","渡辺陽子","小林直美","宮本舞","井上美代子","長井愛子","木島悟志","門脇秀一","安田謙一","柴田由美","徳川雄也","中山俊雄","内山歩","高橋幸雄","佐々木明","田辺洋子","金昭二","畠中博子","勝又愛","新井沙織","河合今日子","高橋祐子","高木知美","中島和子","中村由紀","松本直也","長嶋恭一","大石圭","小倉浩之","浦野政信","岡崎陽子","荒井豪","田中宏樹","篠原千晶","山野裕美子","藤田貴博","飯田千晴","大井圭","前田真由","遠山正典","吉田栄子","小宮山等","渡辺恵子","浅井京子","佐山俊夫","西村健二","三浦英二","田代裕樹","中島優子","小川栄二","井上香織","山岡晃","中川理紗","神田博文","田中佳代子","和田有希","中田恭子","大滝正一","沖朗","山下康之","平尾明美","上田里奈","大井彩子","真田北斗","矢崎貴弘","小谷亮太","山本彩乃","中野由紀子","荒木恭子","長谷川恵","井上尚","江口沙織","吉田崇史","斉藤美穂","和田達夫","伊藤陽一","寺田明子","熊谷夏子","中里美紀","滝沢雄也","金森裕之","山本竜司"};
    static final String[] SAMPLE_CONTACTS_JP_KANA = {"やまもとりゅうじ","えだひさ","こいでいちろう","なかのとものり","ふじもとひろゆき","わたなべたかし","よしみけいじ","こばやしなつみ","さかきさち","さかもとあつし","いわしたせいじ","いのうえまほ","かとうしのぶ","わたなべこういち","とよだひろゆき","やまだわたる","なかはらひでかず","かなざわりょうすけ","くわばらともみ","よしいなほこ","まえだかおる","はらだかずまさ","いのうえまき","よしおかすすむ","うえのちはる","わきたみか","きむらよういち","こんどうあみ","せのおはるか","のもとまさし","かとうゆうき","くまだなつき","かめいさとし","もりむらようへい","はらだあや","なかむらようこ","やまもとじろう","もりさおり","かとうつよし","ふくしまさし","ふくちみき","なかむらゆうこ","かとうたかひさ","やまもとあや","みきおさむ","くろかわあや","こんどうあや","ささきたかゆき","ちばあさこ","いかわはるか","さとうりょうこ","あいはらかな","もりまほ","まつもとひろゆき","まつもとなおと","とくがわけい","まつもとたかお","はらたつや","ほそのこういち","たなかりょうた","よしだかずま","かさいえいじ","なかむらなおき","くさのたくみ","あさぬまあきら","いしだはるな","きたやましんいち","かなやまだいすけ","みやけゆうじ","こぐまゆか","おきあんな","きくちひろかず","いいやままさと","なかむらとしこ","もりもとまこと","あらきめぐみ","まつののぶこ","ほりうちまゆみ","ふじむらけんじ","おがわひでゆき","おおもりじゅん","かわもとけいこ","ただみさき","おぎのあすか","せかわゆうじ","さとうしずか","さのけんた","せのおこうに","はらみき","さいとうとおる","たなかけんた","くぼゆみ","おかだひであき","やまもとみさと","ふじたじゅんこ","やまだひろし","おおのしん","ももたまさこ","かとうあき","いぶきけいすけ","いっしきなおこ","なかむらえいじ","はらだゆう","たちばなかけんいち","すずきひでき","たばたさとこ","ふくだあきら","くろいわかな","よしむらつよし","さとうわたるひら","しばやまみさこ","さとうのりこ","きたはらつよし","いしやまなおと","くろさわひとみ","あらいしょういち","はやさかゆか","たかはしゆうこ","かんだひでと","やまだひでお","ふじわらしょうひら","くりはらゆうてる","やのとおる","うちやまよしこ","もりおかひとみ","あいかわゆい","はっとりのりこ","すずきりゅうのすけ","ほりえゆみ","たていしひかり","うえむらきよし","おちあいあつこ","もりわきまさこ","いしいまもる","かわかみさちこ","おがたさとる","ふくもととも哉[?]","おざわしゅうへい","えぐちたつや","ほんだみき","かのうはるき","ばばたかしたろう","まつしたしょう","つちやあや","かたやまみか","おがわりえ","すずきたかこ","おかもとひであき","なかがわみわ","しいなあい","おおのくみ","いわいかつお","こんどうゆうこ","かわぐちまさあき","あおきえいこ","いそべちえこ","ひらまつともこ","あいだまき","こだいらたくや","まるやまあきら","やすいこうじ","おいかわひろき","さとうあんな","うちやまらん","てらさわひろし","きくちしんいち","たかだけんじ","さたかずよ","はしもとまきこ","こばやしまさこ","おおにしようこ","おうこうじ","あきもとゆうり","よしきこうじ","のだあつし","かとうまいこ","やまだけいご","きたむらまほ","あおやまこうじ","なかにしあき","たなかまもる","おおさきただし","かとうきょうこ","むらかみはるき","かねだかずお","おおたこずえ","やまもとあずさ","はらひろみ","なかやまよしお","こいそつよし","いなばまきこ","こばやしけいいち","あだちえいじ","かがわみか","とみたかずみ","くないしんじつ","まつもとかおり","たかはしだいき","あいはらゆか","みやざきじつ","しみずあやこ","かとうみわ","はらあすか","いしもとりん","なかむらあやか","のさきしんじ","いしわたひろゆき","いのうえさちこ","りんせん","しばたゆみこ","かわいしおり","やましたやすし","さとうじろう","なかざわちはる","かわさきたかこ","むらやまあきら","なかむらまり","たぐちたつや","いちのせかおる","なかのまこと","いずみようすけ","つついみやこ","ひらのゆか","いしかわあきら","ほしのななこ","こばやしあきこ","しもかわみき","おおくぼまお","こんどうたかし","いしばしひろみ","まなべたろう","にしかわてつや","ぼしせい","こんどうとしひこ","いしいちはる","くろきともこ","よしきゆうすけ","いのうえかおる","のもとみほ","いのうえりさ","つじあきひさ","おおのいずみ","いいだみちこ","のだだいき","たなかのぞみ","ひらつかきょうこ","いとうゆうすけ","こばやししげる","いわさきひろし","たなかあやこ","さくらいりょうすけ","おおつぼのぞむ","のなかみほ","はやさかゆうこ","はしもとひさこ","いとうじょうじ","こまきゆき","いとうしょうへい","あまのあり","こばやしさゆり","えぐちあやこ","まつしたちなつ","つじたかし","みうらたけし","いわいりゅうのすけ","なりたこういち","ほったりえ","おかむらゆういち","たはらたく","すぎたまり","あいかわみのる","いしかわたかこ","かとうゆう","まつもとのぶゆき","おだみなこ","まつもとだいすけ","こばやしまり","にしもとひろゆき","やまざきまさこ","かんだまさゆきかい","たかひろみ","ほんままき","こいずみようこ","もりしたたくや","おかざきなおこ","ふくもとともや","かわいみつこ","むらたたかし","おだひろしふとし","ふじたみほ","ひらたまさゆき","たけだゆうじ","いりえこうじ","さかがみとおる","はっとりしげる","あおやまけんいち","いずみまりこ","かさはらこういち","しゅういろどり","にしむらかおる","さいとうれいこ","なかざわゆうこ","さかぐちとしゆき","しまだやよい","ゆあさたかし","やまぐちしのぶ","たかやまけいたすく","かのかつひこ","そめやりな","はやさかゆみこ","しまだなおき","おおむらひでと","おかざきはるか","あかいちあき","きむらあきら","おかやまじ","かじはらりょうた","あんざいももこ","にしむらなおき","いまむらゆうこ","いちじょうひでゆき","かわはらけんた","まさきかち","はやかわゆうすけ","さかたまゆみ","よこたあき","うえくさいちろう","かとうあつし","いしだこうへい","かわたかずよし","ほしのひでこ","ほんだこうに","こうのあい","ひさのゆう","よしだいさお","おおのたかひろ","さとうたくや","てづかしずか","さかもとはやと","つしまだいすけ","おおはしけいご","おおさきえみ","いしばしれな","ときみほ","いながきのぶこ","かわもとあきら","ばんゆみこ","いいだなつき","かわかみゆうこ","はしもとたくや","あさかだいすけ","おおたたつや","かたひらまこと","おきおさむ","おおつきいつき","わたなべたかし","どいかずお","つかはらたかし","くりはらゆずる","ぐんじだいゆう","にかいどうのぶこ","かづきとしあき","くりはらまい","みやもとのりこ","あべひろこ","かいまりこ","たちばなるみ","よしいあつし","さくらいあつこ","きょうのぶゆき","かわはらたつお","こいそやすしかい","なかじままき","みうらけん","よしかわあみ","きのしたけんじ","のろちひろ","ふるさわりゅうじ","きたやまみつお","まつおあつし","すずきたえこ","はたけやまきょうこ","あんざいみずほ","かしわばらあゆみ","かめいさとし","よしはらいさお","ないとうてるひこ","まつだたかし","むとうとおる","たなかだいすけ","いしかわもえ","あんどうあみ","なかむらゆき","なつめちはる","おかべひろし","とうさとこ","きくちけいた","ごとうひとみ","とだのぶゆき","やぶきこうへい","よこやまきょうこ","ひらのあり","たけいなおこ","まごゆうこ","あきもとたつお","たかひさこ","くどうあゆみ","おかようこ","とくながなほこ","ささきゆうこ","さとうつよし","つついなししゃ","ばんあきこ","ながたあき","ひがしあきら","なかいしゅういち","かわぐちえみこ","こばやしなおき","いはらまみ","おおしまひでこ","わたなべようこ","こばやしなおみ","みやもとまい","いのうえみよこ","ながいあいこ","きじまさとし","かどわきひでかず","やすだけんいち","しばたゆみ","とくがわゆうや","なかやまとしお","うちやまあゆみ","たかはしゆきお","ささきあきら","たなべようこ","きむしょうじ","はたけなかひろこ","かつまたあい","あらいさおり","かわいきょうこ","たかはしゆうこ","たかぎともみ","なかじまかずこ","なかむらゆき","まつもとなおや","ながしまきょういち","おおいしけい","おぐらひろゆき","うらのまさのぶ","おかざきようこ","あらいつよし","たなかひろき","しのはらちあき","やまのゆみこ","ふじたたかひろ","いいだちはる","おおいけい","まえだまゆ","とおやまただしてん","よしだえいこ","こみやまひとし","わたなべけいこ","あさいきょうこ","さやまとしお","にしむらけんじ","みうらえいじ","たしろゆうき","なかじまゆうこ","おがわえいじ","いのうえかおり","やまおかあきら","なかがわりさ","かんだひろぶみ","たなかかよこ","わだゆき","なかたきょうこ","おおたきしょういち","おきろう","やましたやすゆき","ひらおあけみ","うえだりな","おおいあやこ","さなだほくと","やさきたかひろ","おたにりょうた","やまもとあやの","なかのゆきこ","あらききょうこ","はせがわめぐみ","いのうえしょう","えぐちさおり","よしだたかふみ","さいとうみほ","わだたつお","いとうよういち","てらだあきこ","くまがいなつこ","なかさとみき","たきざわゆうや","かなもりひろゆき","やまもとりゅうじ"};
    static final String[] SAMPLE_CONTACTS_EN_KANA =  {"Tomkiewicz","Zigomalas","Andrade","Mcwalters","Veness","Rampy","Grasmick","Hisaw","Manzella",
            "Klapec","Writer","Erm","Jaret","Bruch","Gastellum","Throssell","Kanne","Julio","Spinello","Lapinski","Gutierres",
            "Salvadore","Teplica","Veigel","Sitra","Kufner","Tauras","Molaison","Growcock","Quarto","Weisinger","Zelaya",
            "Savidge","Ear","Cobbley","Mould","Loperfido","Sperazza","Rawicki","Cua","Dulle","Cornelison","Gunst","Bunselmeyer",
            "Turziano","Orizabal","Clapham","Devereux","Aschoff","Kunimitsu","Mosseri","Sandlin","Neufville","Klingaman","Moonshower",
            "Hiltner","Kopczynski","Salta","Kamens","Chisum","Consolazio","Bairo","Noonon","Cowser","Smethers","Yadao","Hanton","Ferenz","Cratch",
            "Rohaley","Bassil","Rubano","Stifflemire","Paletta","Thurm","Venus","Elkan","Piehler","Shulick","Kham","Mancilla","Brace","Vanwyhe","Filion",
            "Frankel","Joulwan","Dormanen","Coolidge","Drawe","Gazzola","Alpheaus","Ungar","Fleckles","Damato","Fletchen","Gutoski","Riherd",
            "Torner","Delisle","Rosenlof","Alexy","Meenan","Stanwick","Fulda","Creecy","Faurote","Cantua","Ansbro","Mcmillian",
            "Gauthier","Langenbach","Nesset","Ker","Sovel","Tishler","Conatser","Casper","Marruffo","Dease","Hawkin","Alsman",
            "Dondero","Bontemps","Schurman","Pince","Karas","Barbone","Nobel","Slotemaker","Akey","Semrad","Klipfel","Moussette",
            "Panfilov","Mchughes","Pogorelc","Barresi","Stamps","Connley","Mathieson","Outhouse","Burau","Sakshaug","Shuhi","Wilcoxon",
            "Maraia","Crete","Mias","Altobell","Lavista","Mandiola","Vanhooser","Rieger","Yurich","Viengxay","Sutulovich","Wendorf",
            "Langarica","Goossen","Abrahams","Flam","Aloi","Erixon","Puskarich","Favaron","Kozikowski","Wiederin","Montecalvo","Szpak",
            "Jessie","Fend","Guillereault","Paluszynski","Newyear","Cellucci","Knapp","Reinecke","Schlichter","Swaisgood","Babineaux",
            "Bleile","Difiora","Moeder","Smalarz","Polintan","Flotow","Otey","Ratel","Lintner","Speltz","Lemm","Lavezzo","Bowling",
            "Figuera","Zuehl","Geschke","Jaquish","Lin","Sugai","Handsaker","Degenhardt","Danaher","Rodamis","Langer","Choinski",
            "Brau","Donn","Dubberly","Signore","Flamino","Ero","Nitschke","Shadd","Logghe","Semenza","Seeger","Rodrigues","Ozane",
            "Suite","Uken","Loftin","Detamore","Tivis","Besong","Fonua","Erdman","Arey","Pata","Washmuth","Packebush","Bardsley",
            "Sandblom","Rush","Talentino","Smeby","Ventry","Shiraki","Scavuzzo","Fanelli","Dellinger","Strejan","Sheneman","Colamarino",
            "Peay","Drozdenko","Renno","Wassmann","Hilcher","Feeback","Vanacore","Varnado","Driesenga","Featherston","Feagins","Faehnle",
            "Cunningham","Leader","Rufenacht","Goldrup","Miyashiro","Jenious","Dzledzic","Guitierrez","Cos","Cureau","Siske","Strimple","Gumaer",
            "Respicio","Pomarico","Isita","Nuckolls","Villamarin","Kincannon","Hedegore","Hoffstot","Koza","Mercik","Ferre","Zeng","Rardon","Ailey",
            "Smarsh","Breheny","Klitzing","Glasford","Scurci","Kins","Devereux","Syrop","Tarry","Luger","Rivet","Schantini","Fonnesbeck","Mazierski",
            "Okoren","Pelayo","Mccorrison","Groody","Milne","Holtgrewe","Keehner","Brigham","Arlinghaus","Alcazar","Casalenda","Atkison","Goulbourne",
            "Przybyl","Sayre","Muns","Vanscoik","Alsbury","Saltman","Sterback","Kerfoot","Brabble","Ona","Tyburski","Cutlip","Skubis","Marchetta",
            "Torez","Whitrock","Belyea","Mccrossin","Topete","Claybrooks","Gillham","Beyl","Land","Rempel","Meyerhoff","Marse","Marola","Allis",
            "Hysom","Makuch","Raterman","Kobayashi","Holman","Hallford","Shonerd","Mortenson","Flori","Yaklin","Torrain","Kippel","Nahmias",
            "Scandalis","Carsten","Setter","Matsumura","Pelzer","Rohrs","Sarra","Lingo","Mckenize","Meinert","Rubinstein","Reisling","Weatherwax",
            "Luchterhand","Selma","Lucore","Mcclodden","Kho","Poitra","Westad","Bridgford","Brossoit","Hopman","Jirsa","Stpierrie","Rampy","Teisberg",
            "Merriam","Seelig","Argiro","Chiphe","Tropp","Havely","Ritthaler","Mordhorst","Charry","Ringlein","Madlem","Szumski","Mittler","Poisso",
            "Arzilli","Cocherell","Gath","Ziv","Cronholm","Stueber","Prok","Gomoran","Capra","Flory","Steimer","Mellom","Driscol","Parks","Bendle",
            "Imondi","Senechal","Heier","Carris","Oropeza","Ocacio","Sonkens","Plues","Araiza","Frede","Calaf","Yu","Maricle","Donham","Fredrikson",
            "Stackpole","Homer","Asley","Naomi","Perera","Pao","Heilig","Kernagis","Mandril","Hoyal","Marthe","Kopan","Saik","Sorrel","Dibartolo",
            "Aldaco","Bulcao","Lunger","Withers","Study","Gone","Leadbeater","Orloski","Farrin","Tritten","Bowhall","Hascall","Schellenberge",
            "Gross","Adelsperger","Bludworth","Gesell","Gius","Tromblay","Scarsella","Humeniuk","Weissmann","Aronov","Baldock","Blyler","Vera",
            "Knodel","Mossing","Tischner","Yaccarino","Augle","Khov","Yuki","Yafaie","Diazdeleon","Villot","Picciuto","Piatkowski","Rhea","Lohrenz",
            "Walka","Ligons","Jentzen","Fling","Machalek","Alsaqri","Conoly","Dolloff","Reibman","Freeburger","Gaucher","Kono","Brigman",
            "Schlabaugh","Ausdemore","Stancil","Fiorino","Manciel","Katie","Veit","Euresti","Brenning","Keeny","Richan"};

    private static final int HISTORY_AMOUNT = 100;
    private static final int CONTACTS_AMOUNT = SAMPLE_CONTACTS_JP.length;
    private static HashMap<Integer, ContactListItem> sampleContacts;
    private static List<HistoryListItem> sampleHistory;
    private static List<Integer> sampleNumbers;

    public static List<ContactListItem> getSampleContacts(TabTopContact contactType) {
        List<ContactListItem> items = new ArrayList<>();

        for(ContactListItem item : getSampleContacts()) {
            if(item.getLineType() == contactType) {
                items.add(item);
            }
        }

        return items;
    }

    private static List<ContactListItem> getSampleContacts() {
        if(sampleContacts != null) {
            return new ArrayList<>(sampleContacts.values());
        }
        sampleContacts = new HashMap<>();
        int randomOffset = Util.randInt(1, 500);
        List<Integer> sampleNumbers = getUniqueSampleNumbers(CONTACTS_AMOUNT, CONTACTS_AMOUNT, CONTACTS_AMOUNT + 500 + randomOffset);

        if(BuildConfig.DEBUG && SAMPLE_CONTACTS_JP.length != SAMPLE_CONTACTS_JP_KANA.length) {
            throw new AssertionError("Sample contacts size should be equal or we'll get IndexOutOfBoundsException in next loop");
        }

        for(int i = 0; i < SAMPLE_CONTACTS_JP_KANA.length; i++) {
            sampleContacts.put(sampleNumbers.get(i), new ContactListItem(Integer.toString(sampleNumbers.get(i)), SAMPLE_CONTACTS_JP_KANA[i], SAMPLE_CONTACTS_JP[i]));
        }

        return new ArrayList<>(sampleContacts.values());
    }

    public static List<Integer> getUniqueSampleNumbers(int amount, int min, int max) {
        if(sampleNumbers != null) {
            return sampleNumbers;
        }

        sampleNumbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();

        if(!(max - min < amount)) {
            while(uniqueNumbers.size() < amount) {
                uniqueNumbers.add(Util.randInt(min, max));
            }
        }

        sampleNumbers.addAll(uniqueNumbers);
        return sampleNumbers;
    }

    public static ContactListItem getContactForNumber(String telNum) {
        if(sampleContacts == null) {
            getSampleContacts();
        }
        return sampleContacts.get(Integer.parseInt(telNum));
    }

    private static List<Integer> getCurrentSampleNumbers() {
        if(sampleNumbers != null) {
            return sampleNumbers;
        }

        return new ArrayList<>();
    }

    public static String getSampleTime() {
        int hour = Util.randInt(0, 23);
        int minute = Util.randInt(0, 59);
        return String.format(Locale.JAPAN, "%s:%s", hour < 10 ? "0"+hour : hour, minute < 10 ? "0" + minute : minute);
    }

    public static String getSampleDuration() {
        int min = Util.randInt(0, 59);
        int sec = Util.randInt(0, 59);
        return String.format(Locale.JAPAN, "%sm%ss", min < 10 ? "0"+min : min, sec < 10 ? "0" + sec : sec);
    }

    public static List<HistoryListItem> getSampleHistoryItems(int amount) {
        List<HistoryListItem> sampleHistory  = new ArrayList<>();
        List<ContactListItem> sampleContacts = getSampleContacts();

        for(int i = 0; i < amount; i++) {
            CallDirection direction = Util.randInt(0, 1) == 0 ? CallDirection.IN : CallDirection.OUT;
            HistoryListItem entry = new HistoryListItem(sampleContacts.get(i).getTelNumber(), getSampleTime(), direction);
            sampleHistory.add(entry);
        }

        return sampleHistory;
    }

    private static List<HistoryListItem> getCurrentSampleHistoryItems() {
        if(sampleHistory == null) {
            sampleHistory = getSampleHistoryItems(100);
        }
        return sampleHistory;
    }

    public static List<HistoryListItem> getCurrentSampleHistoryItems(CallDirection direction) {
        List<HistoryListItem> items = new ArrayList<>();

        for(HistoryListItem item : getCurrentSampleHistoryItems()) {
            if(item.getDirection() == direction) {
                items.add(item);
            }
        }

        return items;
    }

    public static List<ContactDetailsListItem> getSampleContactDetails(int telNum) {
        List<ContactDetailsListItem> contactDetailsList = new ArrayList<>();
        //too much of a pain in the ass to make random dates and sort them
        final String[] dates = new String[] {"2016.04.22", "2016.04.19", "2016.04.18", "2016.04.16", "2016.04.10"};
        for(String date : dates) {
            contactDetailsList.add(new ContactDetailsListItem(date, null, null, null));
            for(int i = 0; i < Util.randInt(1, 5); i++) {
                contactDetailsList.add(
                        new ContactDetailsListItem(
                                null, getSampleTime(), CallState.values()[Util.randInt(0, CallState.values().length-1)], getSampleDuration()));
            }
        }
        return contactDetailsList;
    }

    public static List<HoldListItem> getSampleHoldList(int amount) {
        List<HoldListItem> holdListItems = new ArrayList<>();
        List<ContactListItem> sampleContacts = getSampleContacts();

        for(int i = 0; i < amount; i++) {
            ContactListItem contactListItem = sampleContacts.get(Util.randInt(0, sampleContacts.size()-1));
            HoldListItem holdListItem = new HoldListItem(contactListItem.getNameKanji(), contactListItem.getTelNumber(), Util.randInt(0, 7000));
            holdListItems.add(holdListItem);
        }

        return holdListItems;
    }
}
