package com.app.nbm.view.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.app.nbm.R;
import com.app.nbm.databinding.ActivityProgramDetailBinding;


public class ProgramDetailActivity extends AppCompatActivity {

    private String TAG = ProgramDetailActivity.class.getSimpleName();
    private Context mContext;
    ActivityProgramDetailBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_program_detail);

        mContext = ProgramDetailActivity.this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(getString(R.string.program_detail));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        binding.tvProgramDetail.setText("\uD83D\uDEA9\uD83E\uDD41\uD83D\uDEA9गुलाल यात्रा-अष्ठम्\uD83D\uDEA9\uD83E\uDD41\uD83D\uDEA9\n" +
                "       \uD83C\uDF009⃣-1⃣0⃣ मार्च 2020\uD83C\uDF00\n" +
                "    \uD83C\uDFAAश्री नाकोड़ा जी-जहाज़ मन्दिर\uD83C\uDFAA\n" +
                "    \uD83C\uDFAA\uD83C\uDFAAतख्तगढ़ और जैतपुरा\uD83C\uDFAA\uD83C\uDFAA\n" +
                "                    साथ-साथ\n" +
                "\n" +
                "        आज,रविवार 1⃣9⃣ जनवरी\n" +
                "                से बुकिंग आरम्भ\n" +
                "   जितने भी सीट/स्लीपर हो,उतने के साथ\n" +
                "               (अधिकतम 15 \uD83D\uDE8D)\n" +
                "               रविवार,1⃣ फ़रवरी\n" +
                "                 को बुकिंग समाप्त\n" +
                "   \n" +
                "\n" +
                "\uD83E\uDD41गुलाल यात्रा अष्ठम् में है ख़ास-\n" +
                "\uD83C\uDF38बसे 15(अधिकतम)\n" +
                "\uD83C\uDF38श्री नाकोड़ा जी में रात्रि विश्राम\n" +
                "\uD83C\uDF38श्री नाकोड़ा जी एवं जैतपुरा तीर्थ पर\n" +
                "               नामचीन संगीतकारों के साथ\n" +
                "                  भव्यतिभव्य “भक्ति संध्या”\n" +
                "\uD83C\uDF38श्री नाकोड़ा जी तीर्थ पर भव्यतिभव्य \n" +
                "          पार्श्वनाथ परमात्मा एवं भैरव जी \n" +
                "                                का “वरघोड़ा”\n" +
                "\uD83C\uDF38जहाज़ मन्दिर-तख्तगढ़-जैतपुरा \n" +
                "           में परमात्मा का “वरघोड़ा”\n" +
                "\uD83C\uDF38लोक कलाकारों के साथ यात्रा रवानगी\n" +
                "\n" +
                "\n" +
                "\uD83E\uDD41यात्रा नकरे\n" +
                "सीट(अधिकतम 480)-> ₹1,300.00\n" +
                "स्लीपर(अधिकतम 225)-> ₹1,800.00\n" +
                "  आना-जाना,रुकना,भोजन एवं अन्य सभी सुविधाओं सहित.....बुकिंग के साथ ही नकरा जमा कराना आवश्यक..\uD83D\uDE4F\n" +
                "\n" +
                "\uD83D\uDEA98 मार्च की शाम को जयपुर से यात्रा प्रस्थान\n" +
                "\uD83D\uDEA911 मार्च की प्रात: यात्रा का पुन: जयपुर आगमन\n" +
                "\n" +
                "\n" +
                "    \uD83D\uDE4F\uD83D\uDE4Fआयोजक एवं निवेदक\uD83D\uDE4F\uD83D\uDE4F\n" +
                "       श्री नाकोड़ा भैरव मण्डल,जयपुर\n" +
                "\n" +
                "\n" +
                "\uD83C\uDF3Aबुकिंग हेतु शीघ्र सम्पर्क करें..\n" +
                "राजेन्द्र,नित्यानन्द नगर-\u202D 94147 66477\u202C\n" +
                "लक्ष्मीकान्त,चित्रकूट- \u202D 99833 02817\u202C\n" +
                "अरुण,मानसरोवर\u202D-      94143 00781\u202C\n" +
                "गिरिश,शक्ति धाम- \u202D    93513 11856\u202C\n" +
                "राजेश,टैगोर नगर-   \u202D    94140 52876\u202C\n" +
                "विकास,नित्यानन्द नगर- 94144 42434\u202C\n" +
                "संजीव,ज़ौहरी बाजार - \u202D78917 11249\u202C\n" +
                "विवेक,किशनपोल-     99289 93000\n" +
                "गिरीश,मान्यावास-      98871 47520\u202C\n" +
                "दीपक,अजमेर रोड़- \u202D    80030 93099\u202C\n" +
                "अरविन्द,किशनगढ़- \u202D    92145 32529\n" +
                "आशीष,अजमेर रोड़- \u202D   99833 12499\u202C\u202C\n" +
                "आशुतोष,वैशाली नगर- 93511 71057\u202C\n" +
                "विजय,झोटवाड़ा- \u202D       94140 59006\u202C\n" +
                "सतीश,मानसरोवर -     99299 62706\u202C\n" +
                "नीरज,मानसरोवर - \u202D     97822 00429\u202C\n" +
                "अमित,न्यू सांगानेर रोड़- \u202D96492 99000\u202C\n" +
                "महेन्द्र,झोटवाड़ा -         96800 26386\u202C\n" +
                "नैना,शक्ति धाम -         93514 69737\n" +
                "अंकुर,किशनपोल -      99296 16106\u202C\n" +
                "महेश,झोटवाड़ा -         94140 74476\n\n\n");


    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}