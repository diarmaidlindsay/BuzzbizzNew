package pulseanddecibels.jp.buzbiznew;

import org.junit.Test;

import pulseanddecibels.jp.buzbiznew.util.Util;

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
        assertEquals("あ", Util.lookupKana('あ'));
        assertEquals("あ", Util.lookupKana('い'));
        assertEquals("あ", Util.lookupKana('う'));
        assertEquals("あ", Util.lookupKana('え'));
        assertEquals("あ", Util.lookupKana('お'));
        assertEquals("か", Util.lookupKana('か'));
        assertEquals("か", Util.lookupKana('き'));
        assertEquals("か", Util.lookupKana('く'));
        assertEquals("か", Util.lookupKana('け'));
        assertEquals("か", Util.lookupKana('こ'));
        assertEquals("さ", Util.lookupKana('さ'));
        assertEquals("さ", Util.lookupKana('し'));
        assertEquals("さ", Util.lookupKana('す'));
        assertEquals("さ", Util.lookupKana('せ'));
        assertEquals("さ", Util.lookupKana('そ'));
        assertEquals("た", Util.lookupKana('た'));
        assertEquals("た", Util.lookupKana('ち'));
        assertEquals("た", Util.lookupKana('つ'));
        assertEquals("た", Util.lookupKana('て'));
        assertEquals("た", Util.lookupKana('と'));
        assertEquals("な", Util.lookupKana('な'));
        assertEquals("な", Util.lookupKana('に'));
        assertEquals("な", Util.lookupKana('ぬ'));
        assertEquals("な", Util.lookupKana('ね'));
        assertEquals("な", Util.lookupKana('の'));
        assertEquals("は", Util.lookupKana('は'));
        assertEquals("は", Util.lookupKana('ひ'));
        assertEquals("は", Util.lookupKana('ふ'));
        assertEquals("は", Util.lookupKana('へ'));
        assertEquals("は", Util.lookupKana('ほ'));
        assertEquals("ま", Util.lookupKana('ま'));
        assertEquals("ま", Util.lookupKana('み'));
        assertEquals("ま", Util.lookupKana('む'));
        assertEquals("ま", Util.lookupKana('め'));
        assertEquals("ま", Util.lookupKana('も'));
        assertEquals("や", Util.lookupKana('や'));
        assertEquals("わ", Util.lookupKana('ゐ'));
        assertEquals("や", Util.lookupKana('ゆ'));
        assertEquals("わ", Util.lookupKana('ゑ'));
        assertEquals("や", Util.lookupKana('よ'));
        assertEquals("ら", Util.lookupKana('ら'));
        assertEquals("ら", Util.lookupKana('り'));
        assertEquals("ら", Util.lookupKana('る'));
        assertEquals("ら", Util.lookupKana('れ'));
        assertEquals("ら", Util.lookupKana('ろ'));
        assertEquals("わ", Util.lookupKana('わ'));
        assertEquals("わ", Util.lookupKana('を'));
        assertEquals("わ", Util.lookupKana('ん'));
        assertEquals("か", Util.lookupKana('が'));
        assertEquals("か", Util.lookupKana('ぎ'));
        assertEquals("か", Util.lookupKana('ぐ'));
        assertEquals("か", Util.lookupKana('げ'));
        assertEquals("か", Util.lookupKana('ご'));
        assertEquals("さ", Util.lookupKana('ざ'));
        assertEquals("さ", Util.lookupKana('じ'));
        assertEquals("さ", Util.lookupKana('ず'));
        assertEquals("さ", Util.lookupKana('ぜ'));
        assertEquals("さ", Util.lookupKana('ぞ'));
        assertEquals("た", Util.lookupKana('だ'));
        assertEquals("た", Util.lookupKana('ぢ'));
        assertEquals("た", Util.lookupKana('づ'));
        assertEquals("た", Util.lookupKana('で'));
        assertEquals("た", Util.lookupKana('ど'));
        assertEquals("は", Util.lookupKana('ば'));
        assertEquals("は", Util.lookupKana('び'));
        assertEquals("は", Util.lookupKana('ぶ'));
        assertEquals("は", Util.lookupKana('べ'));
        assertEquals("は", Util.lookupKana('ぼ'));
        assertEquals("は", Util.lookupKana('ぱ'));
        assertEquals("は", Util.lookupKana('ぴ'));
        assertEquals("は", Util.lookupKana('ぷ'));
        assertEquals("は", Util.lookupKana('ぺ'));
        assertEquals("は", Util.lookupKana('ぽ'));
        assertEquals("あ", Util.lookupKana('ぁ'));
        assertEquals("あ", Util.lookupKana('ぃ'));
        assertEquals("あ", Util.lookupKana('ぅ'));
        assertEquals("あ", Util.lookupKana('ぇ'));
        assertEquals("あ", Util.lookupKana('ぉ'));
        assertEquals("や", Util.lookupKana('ゃ'));
        assertEquals("や", Util.lookupKana('ゅ'));
        assertEquals("や", Util.lookupKana('ょ'));
        assertEquals("た", Util.lookupKana('っ'));
        assertEquals("わ", Util.lookupKana('ゎ'));
    }

    @Test
    public void testKatakanaLookup() {
        assertEquals("あ", Util.lookupKana('ア'));
        assertEquals("あ", Util.lookupKana('イ'));
        assertEquals("あ", Util.lookupKana('ウ'));
        assertEquals("あ", Util.lookupKana('エ'));
        assertEquals("あ", Util.lookupKana('オ'));
        assertEquals("か", Util.lookupKana('カ'));
        assertEquals("か", Util.lookupKana('キ'));
        assertEquals("か", Util.lookupKana('ク'));
        assertEquals("か", Util.lookupKana('ケ'));
        assertEquals("か", Util.lookupKana('コ'));
        assertEquals("さ", Util.lookupKana('サ'));
        assertEquals("さ", Util.lookupKana('シ'));
        assertEquals("さ", Util.lookupKana('ス'));
        assertEquals("さ", Util.lookupKana('セ'));
        assertEquals("さ", Util.lookupKana('ソ'));
        assertEquals("た", Util.lookupKana('タ'));
        assertEquals("た", Util.lookupKana('チ'));
        assertEquals("た", Util.lookupKana('ツ'));
        assertEquals("た", Util.lookupKana('テ'));
        assertEquals("た", Util.lookupKana('ト'));
        assertEquals("な", Util.lookupKana('ナ'));
        assertEquals("な", Util.lookupKana('ニ'));
        assertEquals("な", Util.lookupKana('ヌ'));
        assertEquals("な", Util.lookupKana('ネ'));
        assertEquals("な", Util.lookupKana('ノ'));
        assertEquals("は", Util.lookupKana('ハ'));
        assertEquals("は", Util.lookupKana('ヒ'));
        assertEquals("は", Util.lookupKana('フ'));
        assertEquals("は", Util.lookupKana('ヘ'));
        assertEquals("は", Util.lookupKana('ホ'));
        assertEquals("ま", Util.lookupKana('マ'));
        assertEquals("ま", Util.lookupKana('ミ'));
        assertEquals("ま", Util.lookupKana('ム'));
        assertEquals("ま", Util.lookupKana('メ'));
        assertEquals("ま", Util.lookupKana('モ'));
        assertEquals("や", Util.lookupKana('ヤ'));
        assertEquals("わ", Util.lookupKana('ヰ'));
        assertEquals("や", Util.lookupKana('ユ'));
        assertEquals("わ", Util.lookupKana('ヱ'));
        assertEquals("や", Util.lookupKana('ヨ'));
        assertEquals("ら", Util.lookupKana('ラ'));
        assertEquals("ら", Util.lookupKana('リ'));
        assertEquals("ら", Util.lookupKana('ル'));
        assertEquals("ら", Util.lookupKana('レ'));
        assertEquals("ら", Util.lookupKana('ロ'));
        assertEquals("わ", Util.lookupKana('ワ'));
        assertEquals("わ", Util.lookupKana('ヲ'));
        assertEquals("わ", Util.lookupKana('ン'));
        assertEquals("か", Util.lookupKana('ガ'));
        assertEquals("か", Util.lookupKana('ギ'));
        assertEquals("か", Util.lookupKana('グ'));
        assertEquals("か", Util.lookupKana('ゲ'));
        assertEquals("か", Util.lookupKana('ゴ'));
        assertEquals("さ", Util.lookupKana('ザ'));
        assertEquals("さ", Util.lookupKana('ジ'));
        assertEquals("さ", Util.lookupKana('ズ'));
        assertEquals("さ", Util.lookupKana('ゼ'));
        assertEquals("さ", Util.lookupKana('ゾ'));
        assertEquals("た", Util.lookupKana('ダ'));
        assertEquals("た", Util.lookupKana('ヂ'));
        assertEquals("た", Util.lookupKana('ヅ'));
        assertEquals("た", Util.lookupKana('デ'));
        assertEquals("た", Util.lookupKana('ド'));
        assertEquals("は", Util.lookupKana('バ'));
        assertEquals("は", Util.lookupKana('ビ'));
        assertEquals("は", Util.lookupKana('ブ'));
        assertEquals("は", Util.lookupKana('ベ'));
        assertEquals("は", Util.lookupKana('ボ'));
        assertEquals("は", Util.lookupKana('パ'));
        assertEquals("は", Util.lookupKana('ピ'));
        assertEquals("は", Util.lookupKana('プ'));
        assertEquals("は", Util.lookupKana('ペ'));
        assertEquals("は", Util.lookupKana('ポ'));
        assertEquals("あ", Util.lookupKana('ァ'));
        assertEquals("あ", Util.lookupKana('ィ'));
        assertEquals("あ", Util.lookupKana('ゥ'));
        assertEquals("あ", Util.lookupKana('ェ'));
        assertEquals("あ", Util.lookupKana('ォ'));
        assertEquals("や", Util.lookupKana('ャ'));
        assertEquals("や", Util.lookupKana('ュ'));
        assertEquals("や", Util.lookupKana('ョ'));
        assertEquals("た", Util.lookupKana('ッ'));
        assertEquals("わ", Util.lookupKana('ヮ'));
    }
}
