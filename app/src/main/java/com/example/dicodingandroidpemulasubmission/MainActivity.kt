package com.example.dicodingandroidpemulasubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import com.example.dicodingandroidpemulasubmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        recyclerView = binding.recylerViewMain
        supportActionBar?.title = "My Waifu List"
        setContentView(binding.root)
        showRecyclerView(getWaifuData())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.action_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun getWaifuData(): ArrayList<Waifu> {

        val waifuArray = ArrayList<Waifu>()

        val waifuName = resources.getStringArray(R.array.data_name)
        val waifuVoiceActor = resources.getStringArray(R.array.data_voiced_by)
        val waifuAge = resources.getStringArray(R.array.data_age)
        //val waifuIntro = resources.getStringArray(R.array.data_intro)
        val waifuAnimeTitle = resources.getStringArray(R.array.data_anime_title)
        val waifuBirthday = resources.getStringArray(R.array.data_birth_day)
        val waifuPhoto = resources.obtainTypedArray(R.array.data_waifu_photo)
        //waifuPhoto.recycle()
        val waifuVoiceActorPhoto = resources.obtainTypedArray(R.array.data_voice_photo)
        //waifuVoiceActorPhoto.recycle()

        for (i in waifuName.indices) {
            waifuArray.add(
                Waifu(
                    waifuName[i],
                    waifuVoiceActor[i],
                    waifuAge[i],
                    getWaifuIntro(i),
                    waifuAnimeTitle[i],
                    waifuBirthday[i],
                    waifuPhoto.getResourceId(i, -1),
                    waifuVoiceActorPhoto.getResourceId(i, -1)
                )
            )
        }

        return waifuArray
    }//end getWaifuData()

    private fun showRecyclerView(waifuList: ArrayList<Waifu>) {
        val listWaifuAdapter = WaifuAdapter(waifuList)
        recyclerView.adapter = listWaifuAdapter
    }

    private fun getWaifuIntro(index:Int): String {//I put here because its produced error when i put on the strings.xm
        val waifuIntro = arrayListOf<String>(
            "Rem (レム) is a maid in service of Margrave Roswaal L Mathers alongside her sister, Ram. She is one of the main supporting characters of Re:Zero, with major roles in Arc 2, Arc 3, and Arc 7. During the first half of Arc 2, she also served as the secondary antagonist.\n" +
                    "    While initially distrustful of Subaru, she eventually opened up to him and even developed strong feelings for him after he saved her. However, at the end of Arc 3, she had her name and memories eaten by Lye Batenkaitos and subsequently fell into suspended animation. At the end of Arc 6, she finally woke up from her slumber following Lye's death, but now suffers amnesia due to not having yet regained her memories. She was transported to the Sacred Vollachia Empire with Subaru and Rui Arneb, still without her name and memories.",
            "Fubuki (フブキ, Fubuki; Viz: Blizzard), also known by her hero alias Blizzard of Hell (地獄のフブキ, Jigoku no Fubuki; Viz: Hellish Blizzard) is the B-Class Rank 1 professional hero of the Hero Association. She is an esper, the younger sister of Tatsumaki, and the leader of the Blizzard Group, a B-Class hero faction. She and her sister are known as the Psychic Sisters (エスパー姉妹, Esupā Shimai).Fubuki is currently trying to recruit Saitama into her group. She\'s also a self-declared member of the Saitama Group.",
            "Hinata Uzumaki (うずまきヒナタ, Uzumaki Hinata, née Hyūga (日向)) is a kunoichi of Konohagakure. Formerly the heiress of the Hyūga clan, she lost the position upon being deemed unsuited for the responsibilities of leading the clan. Nonetheless, Hinata persevered and from her observation of Naruto Uzumaki especially, Hinata found an example to follow. Through her membership with Team 8, she sought to become strong enough to change herself, if even a little at a time. A few years after the Fourth Shinobi World War, Hinata joined the Uzumaki clan after marrying Naruto.",
            "Makima (マキマ?) was the main antagonist of the Public Safety Saga. She was a high-ranking Public Safety Devil Hunter who took Denji in as her human pet.\n" +
                    "    She is later revealed to be the Control Devil (支し配はいの悪あく魔ま Shihai no Akuma?) who embodies the fear of control or conquest. Following her death, she is reincarnated as Nayuta.",
            "Yor Forger (ヨル・フォージャー, Yoru Fōjā?), née Briar (ブライア, Buraia?) is the tritagonist of the SPY x FAMILY series. While she works as an ordinary clerk at Berlint City Hall, she also leads a secret life as a Garden assassin with the code name \"Thorn Princess\" (〈いばら姫〉, Ibarahime).\n" +
                    "    She and Loid Forger get married to fulfill their separate goals, with the former becoming the adoptive mother of Anya Forger.",
            "Kurisu Makise (牧瀬 紅莉栖 Makise Kurisu?) is the daughter of Shouichi Makise, a genius girl who graduated from university at the age of seventeen, and a member of the Brain Science Institute at Viktor Chondria University and the Future Gadget Lab. She is a brain scientist (neuroscientist).\n" +
                    "    Kurisu is one of the main characters of Steins;Gate and a major posthumous character in Steins;Gate 0 via Amadeus. She is briefly mentioned in Chaos;Child, and she communicates via the in-universe Twitter (Twipo) in Robotics;Notes and Robotics;Notes DaSH. She is also a major character in ChäoS;Child ~Children's Collapse~.",
            "Erza Scarlet (エルザ・スカーレット Eruza Sukāretto) is an S-Class Mage of the Fairy Tail Guild,[4] wherein she is a member of Team Natsu. She also served as the guild\\'s 7th Guild Master during Makarov's absence in X792.",
            "Mikasa Ackerman (ミカサ・アッカーマン Mikasa Akkāman?) is one of the two deuteragonists of the series, along with Armin Arlert.\n" +
                    "    After her parents were murdered by human traffickers, Mikasa was rescued by Eren Yeager and lived with him and his parents, Grisha and Carla, before the fall of Wall Maria. She is the last descendant of the Shogun clan that stayed on Paradis Island, thereby related to the Azumabito family, and holds significant political power in Hizuru.[12]\n" +
                    "    Though she desires only to live a peaceful life, Mikasa entered into the military—where she is considered the best soldier among the 104th Training Corps. She later enlists in the Survey Corps to follow and protect Eren, becoming one of its greatest assets. She is currently serving as an officer (上官 Jōkan?) in the Corps.",
            "Artoria Pendragon (アルトリア・ペンドラゴン, Arutoria Pendoragon?, also romanized as Arturia and Altria), Class Name Saber (セイバー, Seibā?), is one of the main characters of Fate/Zero and one of the three main heroines of Fate/stay night.\n" +
                    "    She is the Saber-class Servant of Kiritsugu Emiya in the Fourth Holy Grail War and Shirou Emiya in the Fifth Holy Grail War.\n" +
                    "    She is the Servant of Norma Goodfellow (possessed by Manaka Sajyou) in the Labyrinth Holy Grail War of Fate/Labyrinth.\n" +
                    "    She is one of the Heroic Spirits of Ritsuka Fujimaru of the Grand Orders conflicts of Fate/Grand Order, summoned not as a Servant but as a special kind of Guardian.",
            "Yuuki Asuna (結城 明日奈, Yūki Asuna?), known as Asuna (アスナ, Asuna?) in «Sword Art Online» (SAO), «ALfheim Online» (ALO), as well as «Project Alicization», where she had temporarily used the Stacia (ステイシア, Suteishia?) account, is the main heroine of the Sword Art Online series, the deuteragonist of the Aincrad Arc, as well as the protagonist of the Mother\\'s Rosario side story. She is the daughter of the former CEO of RECT Inc.. Asuna was one of the 10,000 players trapped in «Sword Art Online», where she was the sub-leader of the «Knights of the Blood» (KoB) guild.Her skills with the rapier had her earned her the nickname «The Flash» (閃光, Senkō?)"
        )

        return waifuIntro[index]
    }
}