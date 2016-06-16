package pulseanddecibels.jp.buzbiznew;

import org.junit.Test;

import pulseanddecibels.jp.buzbiznew.util.Utils;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Diarmaid Lindsay on 2016/04/19.
 * Copyright Pulse and Decibels 2016
 */
public class UtilsTest {

    @Test
    /**
     * あかさたなはまやらわ
     */
    public void testHiraganaLookup() {
        assertEquals("あ", Utils.lookupKana('あ'));
        assertEquals("あ", Utils.lookupKana('い'));
        assertEquals("あ", Utils.lookupKana('う'));
        assertEquals("あ", Utils.lookupKana('え'));
        assertEquals("あ", Utils.lookupKana('お'));
        assertEquals("か", Utils.lookupKana('か'));
        assertEquals("か", Utils.lookupKana('き'));
        assertEquals("か", Utils.lookupKana('く'));
        assertEquals("か", Utils.lookupKana('け'));
        assertEquals("か", Utils.lookupKana('こ'));
        assertEquals("さ", Utils.lookupKana('さ'));
        assertEquals("さ", Utils.lookupKana('し'));
        assertEquals("さ", Utils.lookupKana('す'));
        assertEquals("さ", Utils.lookupKana('せ'));
        assertEquals("さ", Utils.lookupKana('そ'));
        assertEquals("た", Utils.lookupKana('た'));
        assertEquals("た", Utils.lookupKana('ち'));
        assertEquals("た", Utils.lookupKana('つ'));
        assertEquals("た", Utils.lookupKana('て'));
        assertEquals("た", Utils.lookupKana('と'));
        assertEquals("な", Utils.lookupKana('な'));
        assertEquals("な", Utils.lookupKana('に'));
        assertEquals("な", Utils.lookupKana('ぬ'));
        assertEquals("な", Utils.lookupKana('ね'));
        assertEquals("な", Utils.lookupKana('の'));
        assertEquals("は", Utils.lookupKana('は'));
        assertEquals("は", Utils.lookupKana('ひ'));
        assertEquals("は", Utils.lookupKana('ふ'));
        assertEquals("は", Utils.lookupKana('へ'));
        assertEquals("は", Utils.lookupKana('ほ'));
        assertEquals("ま", Utils.lookupKana('ま'));
        assertEquals("ま", Utils.lookupKana('み'));
        assertEquals("ま", Utils.lookupKana('む'));
        assertEquals("ま", Utils.lookupKana('め'));
        assertEquals("ま", Utils.lookupKana('も'));
        assertEquals("や", Utils.lookupKana('や'));
        assertEquals("わ", Utils.lookupKana('ゐ'));
        assertEquals("や", Utils.lookupKana('ゆ'));
        assertEquals("わ", Utils.lookupKana('ゑ'));
        assertEquals("や", Utils.lookupKana('よ'));
        assertEquals("ら", Utils.lookupKana('ら'));
        assertEquals("ら", Utils.lookupKana('り'));
        assertEquals("ら", Utils.lookupKana('る'));
        assertEquals("ら", Utils.lookupKana('れ'));
        assertEquals("ら", Utils.lookupKana('ろ'));
        assertEquals("わ", Utils.lookupKana('わ'));
        assertEquals("わ", Utils.lookupKana('を'));
        assertEquals("わ", Utils.lookupKana('ん'));
        assertEquals("か", Utils.lookupKana('が'));
        assertEquals("か", Utils.lookupKana('ぎ'));
        assertEquals("か", Utils.lookupKana('ぐ'));
        assertEquals("か", Utils.lookupKana('げ'));
        assertEquals("か", Utils.lookupKana('ご'));
        assertEquals("さ", Utils.lookupKana('ざ'));
        assertEquals("さ", Utils.lookupKana('じ'));
        assertEquals("さ", Utils.lookupKana('ず'));
        assertEquals("さ", Utils.lookupKana('ぜ'));
        assertEquals("さ", Utils.lookupKana('ぞ'));
        assertEquals("た", Utils.lookupKana('だ'));
        assertEquals("た", Utils.lookupKana('ぢ'));
        assertEquals("た", Utils.lookupKana('づ'));
        assertEquals("た", Utils.lookupKana('で'));
        assertEquals("た", Utils.lookupKana('ど'));
        assertEquals("は", Utils.lookupKana('ば'));
        assertEquals("は", Utils.lookupKana('び'));
        assertEquals("は", Utils.lookupKana('ぶ'));
        assertEquals("は", Utils.lookupKana('べ'));
        assertEquals("は", Utils.lookupKana('ぼ'));
        assertEquals("は", Utils.lookupKana('ぱ'));
        assertEquals("は", Utils.lookupKana('ぴ'));
        assertEquals("は", Utils.lookupKana('ぷ'));
        assertEquals("は", Utils.lookupKana('ぺ'));
        assertEquals("は", Utils.lookupKana('ぽ'));
        assertEquals("あ", Utils.lookupKana('ぁ'));
        assertEquals("あ", Utils.lookupKana('ぃ'));
        assertEquals("あ", Utils.lookupKana('ぅ'));
        assertEquals("あ", Utils.lookupKana('ぇ'));
        assertEquals("あ", Utils.lookupKana('ぉ'));
        assertEquals("や", Utils.lookupKana('ゃ'));
        assertEquals("や", Utils.lookupKana('ゅ'));
        assertEquals("や", Utils.lookupKana('ょ'));
        assertEquals("た", Utils.lookupKana('っ'));
        assertEquals("わ", Utils.lookupKana('ゎ'));
    }

    @Test
    public void testKatakanaLookup() {
        assertEquals("あ", Utils.lookupKana('ア'));
        assertEquals("あ", Utils.lookupKana('イ'));
        assertEquals("あ", Utils.lookupKana('ウ'));
        assertEquals("あ", Utils.lookupKana('エ'));
        assertEquals("あ", Utils.lookupKana('オ'));
        assertEquals("か", Utils.lookupKana('カ'));
        assertEquals("か", Utils.lookupKana('キ'));
        assertEquals("か", Utils.lookupKana('ク'));
        assertEquals("か", Utils.lookupKana('ケ'));
        assertEquals("か", Utils.lookupKana('コ'));
        assertEquals("さ", Utils.lookupKana('サ'));
        assertEquals("さ", Utils.lookupKana('シ'));
        assertEquals("さ", Utils.lookupKana('ス'));
        assertEquals("さ", Utils.lookupKana('セ'));
        assertEquals("さ", Utils.lookupKana('ソ'));
        assertEquals("た", Utils.lookupKana('タ'));
        assertEquals("た", Utils.lookupKana('チ'));
        assertEquals("た", Utils.lookupKana('ツ'));
        assertEquals("た", Utils.lookupKana('テ'));
        assertEquals("た", Utils.lookupKana('ト'));
        assertEquals("な", Utils.lookupKana('ナ'));
        assertEquals("な", Utils.lookupKana('ニ'));
        assertEquals("な", Utils.lookupKana('ヌ'));
        assertEquals("な", Utils.lookupKana('ネ'));
        assertEquals("な", Utils.lookupKana('ノ'));
        assertEquals("は", Utils.lookupKana('ハ'));
        assertEquals("は", Utils.lookupKana('ヒ'));
        assertEquals("は", Utils.lookupKana('フ'));
        assertEquals("は", Utils.lookupKana('ヘ'));
        assertEquals("は", Utils.lookupKana('ホ'));
        assertEquals("ま", Utils.lookupKana('マ'));
        assertEquals("ま", Utils.lookupKana('ミ'));
        assertEquals("ま", Utils.lookupKana('ム'));
        assertEquals("ま", Utils.lookupKana('メ'));
        assertEquals("ま", Utils.lookupKana('モ'));
        assertEquals("や", Utils.lookupKana('ヤ'));
        assertEquals("わ", Utils.lookupKana('ヰ'));
        assertEquals("や", Utils.lookupKana('ユ'));
        assertEquals("わ", Utils.lookupKana('ヱ'));
        assertEquals("や", Utils.lookupKana('ヨ'));
        assertEquals("ら", Utils.lookupKana('ラ'));
        assertEquals("ら", Utils.lookupKana('リ'));
        assertEquals("ら", Utils.lookupKana('ル'));
        assertEquals("ら", Utils.lookupKana('レ'));
        assertEquals("ら", Utils.lookupKana('ロ'));
        assertEquals("わ", Utils.lookupKana('ワ'));
        assertEquals("わ", Utils.lookupKana('ヲ'));
        assertEquals("わ", Utils.lookupKana('ン'));
        assertEquals("か", Utils.lookupKana('ガ'));
        assertEquals("か", Utils.lookupKana('ギ'));
        assertEquals("か", Utils.lookupKana('グ'));
        assertEquals("か", Utils.lookupKana('ゲ'));
        assertEquals("か", Utils.lookupKana('ゴ'));
        assertEquals("さ", Utils.lookupKana('ザ'));
        assertEquals("さ", Utils.lookupKana('ジ'));
        assertEquals("さ", Utils.lookupKana('ズ'));
        assertEquals("さ", Utils.lookupKana('ゼ'));
        assertEquals("さ", Utils.lookupKana('ゾ'));
        assertEquals("た", Utils.lookupKana('ダ'));
        assertEquals("た", Utils.lookupKana('ヂ'));
        assertEquals("た", Utils.lookupKana('ヅ'));
        assertEquals("た", Utils.lookupKana('デ'));
        assertEquals("た", Utils.lookupKana('ド'));
        assertEquals("は", Utils.lookupKana('バ'));
        assertEquals("は", Utils.lookupKana('ビ'));
        assertEquals("は", Utils.lookupKana('ブ'));
        assertEquals("は", Utils.lookupKana('ベ'));
        assertEquals("は", Utils.lookupKana('ボ'));
        assertEquals("は", Utils.lookupKana('パ'));
        assertEquals("は", Utils.lookupKana('ピ'));
        assertEquals("は", Utils.lookupKana('プ'));
        assertEquals("は", Utils.lookupKana('ペ'));
        assertEquals("は", Utils.lookupKana('ポ'));
        assertEquals("あ", Utils.lookupKana('ァ'));
        assertEquals("あ", Utils.lookupKana('ィ'));
        assertEquals("あ", Utils.lookupKana('ゥ'));
        assertEquals("あ", Utils.lookupKana('ェ'));
        assertEquals("あ", Utils.lookupKana('ォ'));
        assertEquals("や", Utils.lookupKana('ャ'));
        assertEquals("や", Utils.lookupKana('ュ'));
        assertEquals("や", Utils.lookupKana('ョ'));
        assertEquals("た", Utils.lookupKana('ッ'));
        assertEquals("わ", Utils.lookupKana('ヮ'));
    }
}
