package pulseanddecibels.jp.buzbiznew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import pulseanddecibels.jp.buzbiznew.R;

/**
 * Created by Diarmaid Lindsay on 2016/04/11.
 * Copyright Pulse and Decibels 2016
 *
 * SectionIndexer Info :
 * http://androidopentutorials.com/android-listview-fastscroll/
 */
public class ContactsAdapter extends BaseAdapter implements SectionIndexer {
    List<String> contacts;
    HashMap<String, Integer> mapIndex = new LinkedHashMap<>();
    String[] sections;
    String[] listItems = {"Tomkiewicz","Zigomalas","Andrade","Mcwalters","Veness","Rampy","Grasmick","Hisaw","Manzella","Klapec","Writer","Erm","Jaret","Bruch","Gastellum","Throssell","Kanne","Julio","Spinello","Lapinski","Gutierres","Salvadore","Teplica","Veigel","Sitra","Kufner","Tauras","Molaison","Growcock","Quarto","Weisinger","Zelaya","Savidge","Ear","Cobbley","Mould","Loperfido","Sperazza","Rawicki","Cua","Dulle","Cornelison","Gunst","Bunselmeyer","Turziano","Orizabal","Clapham","Devereux","Aschoff","Kunimitsu","Mosseri","Sandlin","Neufville","Klingaman","Moonshower","Hiltner","Kopczynski","Salta","Kamens","Chisum","Consolazio","Bairo","Noonon","Cowser","Smethers","Yadao","Hanton","Ferenz","Cratch","Rohaley","Bassil","Rubano","Stifflemire","Paletta","Thurm","Venus","Elkan","Piehler","Shulick","Kham","Mancilla","Brace","Vanwyhe","Filion","Frankel","Joulwan","Dormanen","Coolidge","Drawe","Gazzola","Alpheaus","Ungar","Fleckles","Damato","Fletchen","Gutoski","Riherd","Torner","Delisle","Rosenlof","Alexy","Meenan","Stanwick","Fulda","Creecy","Faurote","Cantua","Ansbro","Mcmillian","Gauthier","Langenbach","Nesset","Ker","Sovel","Tishler","Conatser","Casper","Marruffo","Dease","Hawkin","Alsman","Dondero","Bontemps","Schurman","Pince","Karas","Barbone","Nobel","Slotemaker","Akey","Semrad","Klipfel","Moussette","Panfilov","Mchughes","Pogorelc","Barresi","Stamps","Connley","Mathieson","Outhouse","Burau","Sakshaug","Shuhi","Wilcoxon","Maraia","Crete","Mias","Altobell","Lavista","Mandiola","Vanhooser","Rieger","Yurich","Viengxay","Sutulovich","Wendorf","Langarica","Goossen","Abrahams","Flam","Aloi","Erixon","Puskarich","Favaron","Kozikowski","Wiederin","Montecalvo","Szpak","Jessie","Fend","Guillereault","Paluszynski","Newyear","Cellucci","Knapp","Reinecke","Schlichter","Swaisgood","Babineaux","Bleile","Difiora","Moeder","Smalarz","Polintan","Flotow","Otey","Ratel","Lintner","Speltz","Lemm","Lavezzo","Bowling","Figuera","Zuehl","Geschke","Jaquish","Lin","Sugai","Handsaker","Degenhardt","Danaher","Rodamis","Langer","Choinski","Brau","Donn","Dubberly","Signore","Flamino","Ero","Nitschke","Shadd","Logghe","Semenza","Seeger","Rodrigues","Ozane","Suite","Uken","Loftin","Detamore","Tivis","Besong","Fonua","Erdman","Arey","Pata","Washmuth","Packebush","Bardsley","Sandblom","Rush","Talentino","Smeby","Ventry","Shiraki","Scavuzzo","Fanelli","Dellinger","Strejan","Sheneman","Colamarino","Peay","Drozdenko","Renno","Wassmann","Hilcher","Feeback","Vanacore","Varnado","Driesenga","Featherston","Feagins","Faehnle","Cunningham","Leader","Rufenacht","Goldrup","Miyashiro","Jenious","Dzledzic","Guitierrez","Cos","Cureau","Siske","Strimple","Gumaer","Respicio","Pomarico","Isita","Nuckolls","Villamarin","Kincannon","Hedegore","Hoffstot","Koza","Mercik","Ferre","Zeng","Rardon","Ailey","Smarsh","Breheny","Klitzing","Glasford","Scurci","Kins","Devereux","Syrop","Tarry","Luger","Rivet","Schantini","Fonnesbeck","Mazierski","Okoren","Pelayo","Mccorrison","Groody","Milne","Holtgrewe","Keehner","Brigham","Arlinghaus","Alcazar","Casalenda","Atkison","Goulbourne","Przybyl","Sayre","Muns","Vanscoik","Alsbury","Saltman","Sterback","Kerfoot","Brabble","Ona","Tyburski","Cutlip","Skubis","Marchetta","Torez","Whitrock","Belyea","Mccrossin","Topete","Claybrooks","Gillham","Beyl","Land","Rempel","Meyerhoff","Marse","Marola","Allis","Hysom","Makuch","Raterman","Kobayashi","Holman","Hallford","Shonerd","Mortenson","Flori","Yaklin","Torrain","Kippel","Nahmias","Scandalis","Carsten","Setter","Matsumura","Pelzer","Rohrs","Sarra","Lingo","Mckenize","Meinert","Rubinstein","Reisling","Weatherwax","Luchterhand","Selma","Lucore","Mcclodden","Kho","Poitra","Westad","Bridgford","Brossoit","Hopman","Jirsa","Stpierrie","Rampy","Teisberg","Merriam","Seelig","Argiro","Chiphe","Tropp","Havely","Ritthaler","Mordhorst","Charry","Ringlein","Madlem","Szumski","Mittler","Poisso","Arzilli","Cocherell","Gath","Ziv","Cronholm","Stueber","Prok","Gomoran","Capra","Flory","Steimer","Mellom","Driscol","Parks","Bendle","Imondi","Senechal","Heier","Carris","Oropeza","Ocacio","Sonkens","Plues","Araiza","Frede","Calaf","Yu","Maricle","Donham","Fredrikson","Stackpole","Homer","Asley","Naomi","Perera","Pao","Heilig","Kernagis","Mandril","Hoyal","Marthe","Kopan","Saik","Sorrel","Dibartolo","Aldaco","Bulcao","Lunger","Withers","Study","Gone","Leadbeater","Orloski","Farrin","Tritten","Bowhall","Hascall","Schellenberge","Gross","Adelsperger","Bludworth","Gesell","Gius","Tromblay","Scarsella","Humeniuk","Weissmann","Aronov","Baldock","Blyler","Vera","Knodel","Mossing","Tischner","Yaccarino","Augle","Khov","Yuki","Yafaie","Diazdeleon","Villot","Picciuto","Piatkowski","Rhea","Lohrenz","Walka","Ligons","Jentzen","Fling","Machalek","Alsaqri","Conoly","Dolloff","Reibman","Freeburger","Gaucher","Kono","Brigman","Schlabaugh","Ausdemore","Stancil","Fiorino","Manciel","Katie","Veit","Euresti","Brenning","Keeny","Richan"};
    private Context mContext;
    private LayoutInflater layoutInflater;
    private ViewHolderItem viewHolder;

    public ContactsAdapter(Context context) {
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
        contacts = Arrays.asList(listItems);
        Collections.sort(contacts);

        //for fast scroller
        for (int x = 0; x < contacts.size(); x++) {
            String name = contacts.get(x);
            String ch = name.substring(0, 1);
            ch = ch.toUpperCase(Locale.US);

            // HashMap will prevent duplicates
            mapIndex.put(ch, x);
        }

        sections = mapIndex.keySet().toArray(new String[mapIndex.keySet().size()]);
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_contact, parent, false);
            viewHolder = new ViewHolderItem();
            viewHolder.name = (TextView) convertView.findViewById(R.id.contact_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        String name = (String) getItem(position);

        viewHolder.name.setText(name);

        return convertView;
    }

    @Override
    public Object[] getSections() {
        return sections;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return mapIndex.get(sections[sectionIndex]);
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    static class ViewHolderItem {
        TextView name;
    }
}
