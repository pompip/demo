package me.liukc.cpr095.demo4.text.bean;

import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.hxqc.socketlibrary.utils.JSONUtils;

import java.util.ArrayList;

/**
 * Author :liukechong
 * Date : 2015-09-01
 * FIXME
 * Todo
 */
public class MainClass {

    public static void main(String[] args){

        String xxx = "[\n" +
                "\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "{\n" +
                "\n" +
                "    \"brandID\": \"82\",\n" +
                "    \"brandInitial\": \"D\",\n" +
                "    \"brandName\": \"大众\",\n" +
                "    \"brandThumb\": \"http://10.0.12.221:8082/79/d2/79d2a40c617341eb9310bbc36a8ae0e1.png\",\n" +
                "    \"filterKey\": \"b1\",\n" +
                "    \"filterValue\": \"大众\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"brandID\": \"18\",\n" +
                "    \"brandInitial\": \"D\",\n" +
                "    \"brandName\": \"东风风神\",\n" +
                "    \"brandThumb\": \"http://10.0.12.221:8082/e0/14/e014f05ccea00bcc86e1ad670d5c7eeb.png\",\n" +
                "    \"filterKey\": \"b1\",\n" +
                "    \"filterValue\": \"东风风神\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "        {\n" +
                "            \"brandID\": \"17\",\n" +
                "            \"brandInitial\": \"D\",\n" +
                "            \"brandName\": \"东风风行\",\n" +
                "            \"brandThumb\": \"http://10.0.12.221:8082/4b/43/4b43016670a44279b27327351236159d.png\",\n" +
                "            \"filterKey\": \"b1\",\n" +
                "            \"filterValue\": \"东风风行\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupTag\": \"D\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "{\n" +
                "\n" +
                "    \"brandID\": \"77\",\n" +
                "    \"brandInitial\": \"A\",\n" +
                "    \"brandName\": \"奥迪\",\n" +
                "    \"brandThumb\": \"http://10.0.12.221:8082/e5/27/e527b8a1bd59c5b71b6352a2abbb00ca.png\",\n" +
                "    \"filterKey\": \"b1\",\n" +
                "    \"filterValue\": \"奥迪\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"brandID\": \"157\",\n" +
                "    \"brandInitial\": \"R\",\n" +
                "    \"brandName\": \"日产\",\n" +
                "    \"brandThumb\": \"http://10.0.12.221:8082/b5/33/b533cb131d27f75dd032ea5d84e4fae6.jpg\",\n" +
                "    \"filterKey\": \"b1\",\n" +
                "    \"filterValue\": \"日产\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"brandID\": \"3\",\n" +
                "    \"brandInitial\": \"B\",\n" +
                "    \"brandName\": \"北京汽车\",\n" +
                "    \"brandThumb\": \"http://10.0.12.221:8082/07/f4/07f437d319e4a25e0e831ca3d83044d5.png\",\n" +
                "    \"filterKey\": \"b1\",\n" +
                "    \"filterValue\": \"北京汽车\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "        {\n" +
                "            \"brandID\": \"91\",\n" +
                "            \"brandInitial\": \"B\",\n" +
                "            \"brandName\": \"本田\",\n" +
                "            \"brandThumb\": \"http://10.0.12.221:8082/18/fd/18fde92f03396879a17ec31a1f7b70c0.png\",\n" +
                "            \"filterKey\": \"b1\",\n" +
                "            \"filterValue\": \"本田\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupTag\": \"HOT\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "        {\n" +
                "            \"brandID\": \"77\",\n" +
                "            \"brandInitial\": \"A\",\n" +
                "            \"brandName\": \"奥迪\",\n" +
                "            \"brandThumb\": \"http://10.0.12.221:8082/e5/27/e527b8a1bd59c5b71b6352a2abbb00ca.png\",\n" +
                "            \"filterKey\": \"b1\",\n" +
                "            \"filterValue\": \"奥迪\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupTag\": \"A\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "        {\n" +
                "            \"brandID\": \"157\",\n" +
                "            \"brandInitial\": \"R\",\n" +
                "            \"brandName\": \"日产\",\n" +
                "            \"brandThumb\": \"http://10.0.12.221:8082/b5/33/b533cb131d27f75dd032ea5d84e4fae6.jpg\",\n" +
                "            \"filterKey\": \"b1\",\n" +
                "            \"filterValue\": \"日产\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupTag\": \"R\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "{\n" +
                "\n" +
                "    \"brandID\": \"3\",\n" +
                "    \"brandInitial\": \"B\",\n" +
                "    \"brandName\": \"北京汽车\",\n" +
                "    \"brandThumb\": \"http://10.0.12.221:8082/07/f4/07f437d319e4a25e0e831ca3d83044d5.png\",\n" +
                "    \"filterKey\": \"b1\",\n" +
                "    \"filterValue\": \"北京汽车\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"brandID\": \"91\",\n" +
                "    \"brandInitial\": \"B\",\n" +
                "    \"brandName\": \"本田\",\n" +
                "    \"brandThumb\": \"http://10.0.12.221:8082/18/fd/18fde92f03396879a17ec31a1f7b70c0.png\",\n" +
                "    \"filterKey\": \"b1\",\n" +
                "    \"filterValue\": \"本田\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"brandID\": \"105\",\n" +
                "    \"brandInitial\": \"B\",\n" +
                "    \"brandName\": \"别克\",\n" +
                "    \"brandThumb\": \"http://10.0.12.221:8082/65/e7/65e794b466721c20c792232d48a0e654.png\",\n" +
                "    \"filterKey\": \"b1\",\n" +
                "    \"filterValue\": \"别克\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"brandID\": \"81\",\n" +
                "    \"brandInitial\": \"B\",\n" +
                "    \"brandName\": \"奔驰\",\n" +
                "    \"brandThumb\": \"http://10.0.12.221:8082/85/15/851585371a5c78fd3df2ccece894ac6c.png\",\n" +
                "    \"filterKey\": \"b1\",\n" +
                "    \"filterValue\": \"奔驰\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"brandID\": \"79\",\n" +
                "    \"brandInitial\": \"B\",\n" +
                "    \"brandName\": \"宝马\",\n" +
                "    \"brandThumb\": \"http://10.0.12.221:8082/3d/e6/3de6b010b2a2b9a84c83e746361755f6.jpg\",\n" +
                "    \"filterKey\": \"b1\",\n" +
                "    \"filterValue\": \"宝马\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "        {\n" +
                "            \"brandID\": \"122\",\n" +
                "            \"brandInitial\": \"B\",\n" +
                "            \"brandName\": \"标致\",\n" +
                "            \"brandThumb\": \"http://10.0.12.221:8082/6a/fa/6afa73289dc040468372819ade2732c7.png\",\n" +
                "            \"filterKey\": \"b1\",\n" +
                "            \"filterValue\": \"标致\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupTag\": \"B\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "        {\n" +
                "            \"brandID\": \"101\",\n" +
                "            \"brandInitial\": \"S\",\n" +
                "            \"brandName\": \"三菱\",\n" +
                "            \"brandThumb\": \"http://10.0.12.221:8082/ad/33/ad33e9dd13262ea1dfcb5402aa5cf036.jpg\",\n" +
                "            \"filterKey\": \"b1\",\n" +
                "            \"filterValue\": \"三菱\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupTag\": \"S\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "{\n" +
                "\n" +
                "    \"brandID\": \"93\",\n" +
                "    \"brandInitial\": \"F\",\n" +
                "    \"brandName\": \"丰田\",\n" +
                "    \"brandThumb\": \"http://10.0.12.221:8082/7d/6f/7d6f435bd5c41684267b5c2b10c1dfcc.png\",\n" +
                "    \"filterKey\": \"b1\",\n" +
                "    \"filterValue\": \"丰田\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "        {\n" +
                "            \"brandID\": \"107\",\n" +
                "            \"brandInitial\": \"F\",\n" +
                "            \"brandName\": \"福特\",\n" +
                "            \"brandThumb\": \"http://10.0.12.221:8082/0e/b9/0eb9d53f948db9b037f72a28fd326081.png\",\n" +
                "            \"filterKey\": \"b1\",\n" +
                "            \"filterValue\": \"福特\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupTag\": \"F\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "        {\n" +
                "            \"brandID\": \"142\",\n" +
                "            \"brandInitial\": \"L\",\n" +
                "            \"brandName\": \"兰博基尼\",\n" +
                "            \"brandThumb\": \"http://10.0.12.221:8082/e1/50/e150d7f6fbd0abd3d1ee293ece3ff38e.jpg\",\n" +
                "            \"filterKey\": \"b1\",\n" +
                "            \"filterValue\": \"兰博基尼\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupTag\": \"L\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "        {\n" +
                "            \"brandID\": \"112\",\n" +
                "            \"brandInitial\": \"K\",\n" +
                "            \"brandName\": \"凯迪拉克\",\n" +
                "            \"brandThumb\": \"http://10.0.12.221:8082/8f/af/8faface73bcdcd9e88f5e15dabe86484.png\",\n" +
                "            \"filterKey\": \"b1\",\n" +
                "            \"filterValue\": \"凯迪拉克\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupTag\": \"K\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "        {\n" +
                "            \"brandID\": \"28\",\n" +
                "            \"brandInitial\": \"H\",\n" +
                "            \"brandName\": \"哈弗\",\n" +
                "            \"brandThumb\": \"http://10.0.12.221:8082/ad/92/ad929e8b34fe53738194bf54b9af66ab.jpg\",\n" +
                "            \"filterKey\": \"b1\",\n" +
                "            \"filterValue\": \"哈弗\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupTag\": \"H\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "{\n" +
                "\n" +
                "    \"brandID\": \"57\",\n" +
                "    \"brandInitial\": \"Q\",\n" +
                "    \"brandName\": \"奇瑞\",\n" +
                "    \"brandThumb\": \"http://10.0.12.221:8082/70/72/7072a8502814431bfea38c28e77569c1.jpg\",\n" +
                "    \"filterKey\": \"b1\",\n" +
                "    \"filterValue\": \"奇瑞\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "        {\n" +
                "            \"brandID\": \"119\",\n" +
                "            \"brandInitial\": \"Q\",\n" +
                "            \"brandName\": \"起亚\",\n" +
                "            \"brandThumb\": \"http://10.0.12.221:8082/15/34/153406d5386cfb1c819bc16ec33eda32.png\",\n" +
                "            \"filterKey\": \"b1\",\n" +
                "            \"filterValue\": \"起亚\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupTag\": \"Q\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "        {\n" +
                "            \"brandID\": \"121\",\n" +
                "            \"brandInitial\": \"X\",\n" +
                "            \"brandName\": \"现代\",\n" +
                "            \"brandThumb\": \"http://10.0.12.221:8082/bd/83/bd839da39c76e4c6d938a5667dc4caa7.png\",\n" +
                "            \"filterKey\": \"b1\",\n" +
                "            \"filterValue\": \"现代\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupTag\": \"X\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\n" +
                "    \"group\": \n" +
                "\n" +
                "[\n" +
                "\n" +
                "            {\n" +
                "                \"brandID\": \"97\",\n" +
                "                \"brandInitial\": \"M\",\n" +
                "                \"brandName\": \"马自达\",\n" +
                "                \"brandThumb\": \"http://10.0.12.221:8082/d6/8d/d68dc42a7c5e9cf2b65b6b4b15c6adfd.png\",\n" +
                "                \"filterKey\": \"b1\",\n" +
                "                \"filterValue\": \"马自达\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"groupTag\": \"M\"\n" +
                "    }\n" +
                "\n" +
                "]";
        ArrayList<Group> groups = JSONUtils.fromJson(xxx, new TypeToken<ArrayList<Group>>() {
        });
        for(Group xx: groups){
            Log.e("xx", "main-- "+xx.groupTag);
        }
    }
}
