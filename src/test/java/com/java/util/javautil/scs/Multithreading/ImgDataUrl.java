package com.java.util.javautil.scs.Multithreading;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImgDataUrl {

    /**
     * 对Base64字符串解码并生成图片
     * @param imgStr
     * @param imgName
     * @param imgPath
     * @return
     */
    public static boolean GenerateImage(String imgStr, String imgName, String imgPath) {
        if (imgStr == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    //调整异常数据
                    b[i] += 256;
                }
                File headPath = new File(imgPath);
                //判断文件夹是否创建，没有创建则创建新文件夹
                if (!headPath.exists()) {
                    headPath.mkdirs();
                }
                //定义图片路径
                String imgFilePath = imgPath + "\\" + imgName + ".png";
                //新生成的图片
                OutputStream out = new FileOutputStream(imgFilePath);
                out.write(b);
                out.flush();
                out.close();
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    public static void main(String[] args) {
        GenerateImage("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAArwAAACsCAMAAACuLY/DAAADAFBMVEVMaXFZVlZZVlZZVlZZVlZZVlZZVlZZVlZZVlZZVlZZVlZZVla+TRpZVlZZVlZZVlZZVla0Sxy8TRvAUBvCVR3eXRq1XCS6ThvTTxjJTxm8URzqizPbURXDTxrCby3nVBDmURG+ZCfeUBTLThngUxPQXh3PUBjdVRXGTxrHYSPQTxjYURbkVRLSZiLegjLMWh3haSDgWRTRVxq/Vx/SfDLDVhzoWBLoXhPNWBvqgi3YWRnRYR/layHIcy7OdC3Vei/iURPshzDETRrVXhzieyvkXhXZVhfVUxjseyfcayPDaCm8YibLXyHNZiTlhzPacCblYxvPUxnnVRHpaR3UWxvVZiLpYxfndCTUfDHlgi7seCXhWRXZXx3iZBzZaCHafjDUaSPcXhnlZhreWxfYWxnhbSHnXxPdfS7obSDqbh/DXCHtdCHiXBXwjjPkdSbqdCHbdSnEYSTDZCbkWxTviC7KZSTpZhfwijDbXBnvgirjbyHsciDugCjpZxvtgyzgeCnuhi7caiPsbBzlXhftbxznciLEWB5ZVlbrYQ/rYxDrZBHsZhPsaRXrYg/sZRHrYhDxiS3saBTsahbxjTDxjC/vfSTtbBftbxrwhyvsZxTzmDfwgijwhCnzljbvfiXvgCbtchzveyPucx3tbRjwhyzrYA/qVxDueiLueCHudx/xjjHxii7tcxztcRvtbhjsZRPxiCzxiy7yjzHrXw/ykjTwgynwhSrykDLykTPwhirvfybrZBDqVQ/ylDXykTLykjPykzTrXQ/vgSfsZxPsaxfzlzfylTXvfCPrXg/saRTqWQ/udB7qWg/ueSLqWxDwgiftcBvrXBDqURDudh/udR7saxbqUxDudB3udh7saRbtcBrrZBTvfSXsaBXrYBHrYhPrXhDrYRDudiLsZRTtbh7saRrueiPrXBPtcRzwhCrtciHtbhrrYhHrYRPqWhLsZhfudyHueCLtbBrxiC3taxztcR7xiy/vgCfveyTudCHucx7tbRvxiS7xjDDxjDHtch4TyfjSAAAAh3RSTlMAYOAwEPCgwECAINBQcFCQsBY9UE/NFim1hRTH0GIU9fU93ZbbSpPOdHWlweiljJbdy6Q8Sif09HDXsFzpJzhu6eV1j6vYwLP00U8qhZWqjeiB9PV+tfTYXLrz28Hbw31trce8nqnlnvX0Y/K58svksGNj5/OG8/Kc8bny8fPzzfPR/Ov9z1PpaScSAAAACXBIWXMAAAsSAAALEgHS3X78AAAeQElEQVR4nO2deXwUx5XHW8fovjlkMIcwGAgY1thgY+OLYJs4G9sx8Z3EsXNnk002597XX0KWY2xpA9EqEBxL40Q4YZeRBGhHa6QQ0EryhJG9453MaHRfgCQOgRDYZj/doxl11119TA92/f6yUVW97upvv3n16mjJoO5ef+/atder9MjatevvMdqqkJC1Wv+lR66vOXSotvZIY+Ox3bt37z52rLHxyJHa2kMHazZfv/bpRaL/heJR96y9/uCh2iONx3b/Qda/R6T83+7djY21hw5+uPmRewXAQvGlpx/5y0O1jbt3q6kFJCPceKS25sM7vnS3eHpCcaJpcvHczugPfzh25JDgVyg+dPfazQq5dHAjYcRuhd9nnhYPUMhWrX+kRo4WmMmN8NtYe7B8swh/hezT+utrlHBBh3Yfqz1Y/qO1Al8hW7T++pq3jigJMX1qrD34wb88KvAVirnufqb8kBF05STwkdoP3998r3h2QjHVorX7yt9qPGZUjbUHLlbd8Wnx7IRip/WbPzwgz6IZV+3B8vdHviFiB6EYadEzF2veqj1ikt468MH5zcL5CsVE6//6w0O1ZupQzcUq4XyFYqBvXKw5+Ja5OnTgg/N3iHVnQhZr0R0Xaw4eMl0HPnz/n0TaQchS3fOj8gP/bYUOlO+r/yvx7ISs073nyw8ctEYHyveN/LMIfIWs0trz5TUHrFJN+fmRp/5cPDshS3R/1cXyGgv1wfmRTy0Rj07IAt1fta/cWl08XyfoFbJA99e//4HF8H6wr0rQK2S+7q9/5d+sl6BXyHzdP3L+Ygzgvfh+VeWzgl4hM3V/XdW+/4yF9p2vn3xW5ByEzNO9I1Xv74uRzo9MPiXyvUJm6em6qvOvxExVI5PfFY9OyBzd87exZPeVV6rqGsRMsZApWnRHfdV/8KsqLD01D1cGnxfPTsgEPVN3uIpTh+vrR0bqZI2M1Ncf/jlv/ZFJkXIQMkFfaq7/ObsOH64fqatsnmwIRtTQMFlZVzdSf5ijlfq6oBi0CRnWPf8wwoydAu5kQ/DSYG/v1Mmwpnp7z14KBhuaufitbw6uEc9OyKDuqKw/zKb6X1Q2NwQHe6dOXujv77/roYceevjhJx566KH+/gsnp3oHg3smK3/B3FZdQ6/hfW3JaRolxS0K2utMi4MrMlEJqVolx870o5N19UwaqVPIlcG9ec0PNBHr3E8//Nw3+0/2Dob9L1tzzYN3zTV47WnFGqUabM46aa+zOG6vUyX2nk12aO8uN2bXePenKn/BpMrm4KXek/3933ziB2jmlvz4ZoXfyco6tgaDvUYDBwGvdeLo2Wzg9mL2y/LdBibUKisbgr0n+yf+9ROkxpas+ebJ3sE9zUzvQ93k4EmDgYOA1zrx9Gyq9vYyY3SJmy411zGosiF49mT/xBPU9NbcT9x1slcOHlgaDfbebOzqafAmpRmRsWvT6CMObxJwf+naP4NBsRGpxzXfC1YyqCE4ONU/8Rzbcpoff2vqbLChmaXZwZNER04VDV7AI/DJTD/+EYdXytXenyND89d0I48BkMqlPHqpgYpYcxjdu5h/4ueu6T/JhO9ksNfYmM1SeOPb8/L9oujIw5B7FhA4ZtOWtwbeRc/uaf4jRc17LvVemJh4mOfGl9zcPzUY/CWt6T82XJriaheUlfDinpeuOAR8AnqkvQxzboYgvvo5gMEc9R+tgffRYEMzRYrbHbiLdy53zYQS+lI0Gez9lhHXayW8OMdrtPd1y8hlWA4v2NWJ6mSvJfAuejbY8Euy9hw/c3Vi4Dl+wr7/uQu9l/bQmg8OXjXiei2EF/u4DHe/Xhm5DOvhzQAsqpO9lsD76KU9dHYvTAzoSscuUeiltN9w3JDrtRBebMRruPv1yshlWA8vRGgS/k9GFH0u3z6+p4EoOdwdGNCZEZh7c7885UZW8OwFAwkH6+DFPy0THwSfjFxGDOBNTtSaVCV7rYD3+bM/20NU8DUD7Cr0Tg3STAxO3aW3fSvhxacajPe/Thm5jBjACz6M4uzoX6yA96nBIJksJWYw4Bhlei+RTew5fqb/+7oNWAYvYY7IhAegT0YuIxbwSnlamzPJXgvgvaf3tZ+RdfbCwMBn+G97RnM/N3zmONnG8bNXn9PdPie82dgEFZBkL07A2zTxQfDJyGXEBN4MINmbF/2DoYnOTE2j0/B+jcLV8bevTow/wX/Xai353NWzNCuXJ3RvhOeEFx8LAPFaIsGmYQj1yshlxAReyMPmMNShS/sQp5/ht98mYyXnd79o1PInJqYGyWZem+rX7d3NgjcB6HWC4xXwEqR1ktpkr26h4N009cZxkt44c2HgSeOHg6wZ7iXbee3MBd3Lc8yCl8PxxnCZAtGS9oLTYdkBLzhmM2VlLwrev+sdfI2gwTNXJ8b/wrjpuTdfpRvS+46YBC/Y5yTHG5fwothCF8hlXtClqe+Y/kcajSnANZuxtwUF79+fJSH12ttT/QNfMMG0tKT/MsVSm+64wSR4walNos1rG15DS5WMLtDRJwS8m9p+/QZBb787PPCk0V06Ya3pp5nq1xtamwMvl+MV8BIFbqrIplWgCwHv1955mwSUHDT8mXHDsub+4zDR1htnrg7ofE3MgZfL8Qp4yQIMOIyP2RDwfq/3bYLOtvUPfNaw2Wl9ZuLqGZKxM1cndM6EmAIvn+OlwQsMnIwsCiZaojKFLmA5vOCmijxqDZpgeO+++s6vCXp3eCBgbJODWp/tbztDMHbm6hWd6WRT4OVzvBR4waSbkREL0RKVKXQBy+EFN1UYX9MPw/v8ZSJOl6+Mm+Z4FddLelXOtJ3QacwMeDkdLxkpUwcsREtUM+gCZsKrPTUj8pqCXUBzBlTB8H7t8ju/wUt2vCZFvJIS9Z5oI1j7TdsJPy3oTUBkMtPTgcwMlO4E8rdIeMEgjXYzwOPU/tFUt0O0hGeKWMBMeNPwfzJTMLxPkWh65/KJ8S5zUg1hrbnyJuVdoWWUDXb6zI2DAh1vOvk6yEiBm2GMPVCSpY81vCfa3sHr3b0TgTvNtH/rwDDJXtvwAM3PWwYv9+gYaFP9pyTgF7M40dAub4KljzW8Nw6/9394vXfC32XC5JpKXzz1K4K9d/eeo82HWAUvt+MlwJsMTO2bLMJlsMPLfpKFpn4mENgi+i528D4/3PYuXm9eGb/d3AvYcm4vwWDb3nO0EZtV8AJRM0NaEmhz5g8Ws2sOvOyi17cL3keHL7dhdXl4IGDKzPCMbh04QTDYtvfcONcd6BQML7htkO54JeC3PfrvprObh7OkiAoOtQBF9Pp2wfvl4V+9h9WvdvlHzUvyhvWTU2/iDb6398r4rTx3oFMwvPyOF6cMs9mlXAsVHGoBiuj1KfCiE0R0ZQDtoODFa++V8VEKS9z6wjmKxdnkFq2BV4fjxSgNHKsZFmVVAJUtagGK6PUp8Op9ZOBTguA9t5eA0vC5gMkhryRtGThBgveUn7KwzBp4TXO8Zu7SCouGG7UwV2u66tsG72/fxGuXf3QO/82SNdt/ai/e4t5TfkquzBJ4zXK8GaZcnUYO8McTlKb0xwreDVcI8O7d5R+9hf9myZo/foUE7y6/Dovgymfu6WGTHK/5bpdh+xf5xj/K8N54bngvVsNX/KMmzg1Pa/zcCYLJU34dvh7qHU54zXG8CcAcdDH/5ATcAme6+eMF7xUSvOfGRynDJx36ovnwQs+cE17Qc+fg8vUEj4xCtziFz4VnQ4O9FHol8o1/tD3vid9itevo+JD58M45ugtv8rdX9MAL3TYfvKDjxQt7BUh0ix1cy3EQATMDux9rz0uEN3BNwAsue+aFFwqZccI8+YxcbHosMYHZ98Jul4ndjzG8m87tOoHVKX9gyMwlZWF9wX8Kb/LEuXF+eMElXJzwJjP3JmrLbHICeVLCkcK0DB2Vp2BiVz+82ZpZAvzAkGrALni37Nz1J6x+5w8MMfUfl7b4f4c3+aednfzwwoN8LnjZcwTQA87IzmOolkl1v8moa2AcNpJvnFBAu+QYv1ScaoAPXvYBKw3ex4+e2oXV6/4uC+B9wf863uSuozo8L/xm88ALLvgnCEi5JrFPBKcQo19UxOygbeSIiHzjhAJAqI+1RzXABy/pXrTvMDXmJcMbGCog2Ypq4xz27Owc0+GF6eOBl93xQs4JOUrDVc7FzTbkoJrJZN7zRr5xUoE8alU2A7bBW0aA91QZ44DtztHRIeaEsOnwwuM1Hng5HC8Ug4KbLCnKzEaEDznIiJAjx0a+cVIBYAkz7nWhGrANXv/rv8NK9rws8L4QCARCP2QoqGiOfyfBZFkfN7wIhDjg5ZgVg8c0CPBS09Bps7DygPAXk2LjOVWRfOPEAlrjuPEh1YB98JJJGlpJshXWxr7Ozr7RMXrBsJ4kvi864EVkuqD+A8ZVM93C4XiLYW8Ibr8oDqcW0N40UiRKZnI2GvM8rqkN8o0TCwCvPcYs1YBt8HYefR2vsj6GaGDDT/x+//joGGtGOODfibe40x94kLGdqBAEwF2ck+LQ3HhEybjJtLS0tDxao0B/Js6EBRkphJfCofCbhCmSyLnRmHqN+ALAm4tJb1AN2AWvRIZ3PERH6cv+sqNlnV2s8M6mwNvFu5oCEfIiuzg5IRXbLWgBbwVqXe3MY3MACQVy/teRgvmrI513URD1xgkFtLBgNvtTDdgGb1/ZTrzKKkY/T7Il6/GKsqM7OeDd2OcnW+SFFzzRLdp/SXkJwAA/OhXGBC/4ViCzBeEOdaSgolScbyUohbYAEhaVLUIBpmwZ1YBt8H6WgtJYPrnrNvzEf3TnzqPs8H6V/Lr0hRaytYO5JVX/yV2amQ6MocP+kAleIJZGf1olqbg4MxfbnNrbMyhVz9EkRuAF7hF9i/EL75dJ8B71B8YoLM3pPLqTC94HOknw+vt4V1MgJ3ej8CoJVi2/aSmM8AJuE7MbJ4niKzNyWbPButA1eDI6MOJEXgGpPqqV2MH7QmfZUbz8gSHy7MPjAb9cuaxzdGwWsWBE87toBimuHhQy16qGV3mkGsIyQHfM1LD+LZk5LOGDTnSNfpNCG3ojs2XE+orsgndLRdn/4vVSX4gY9N7a1alUZ4d3Y+Algj05dmZqZkbIxQUAvPK/sM62RgX84Bs6oZMePjiYXiiUKA2jekYl4BVF/YwQ6yuyC94b+14qw8vfNzpWSDD2wHRtfwUrvF+h2VvB1ExU6LW4MLzFxQ7s/CxTw9zwq5SUzRL6OvKy+Ydrhr8GRM+WketLNsK7IUCEqTMwthRva0ug088H7/zRCj/B3kt9Ic4tbKhcAxpeTvcLHPNIPTMSp4yEPI6cQ2IKmCGhir3xYhRZ9GwZub5kI7zSk50EmMpe6uu+CWvq1q4IiczwbgyQzQVYpvTUQqdLMfDK0S9j6ArOvOn6FlNSdgrP2p3INfIBzNc4RBY9W0auL9kJ75zSl0gqDeGpfCDwaqRmacjJBO8DfZ0kaxVdY2zL2CJCzVCQ4JVTskxkgMM17h/0tHQejwsqMS+bNQbmaxiGT5stQyzrpdS3E94tNJyGcFHoV7sqosUY4Z09SnlVem5jaEUlzA4eArzUxbVhJSIaZFVSAm7+jE+p6TkMvxOcbUL1gfcf7ht6R9gG741dr5Jw6uwLYYZss7tUIDLCOydAM8Y3XsPt4FH6j3BoGDUvxXvEf7ReQi7TtERibg5bRJGYl025VpZWVHcON6C9YDirQqtvI7zSKNn1lnYNbUXZmf/1QKeaOhZ4Z4+WUmyNzaO3gr1ZqP+S8BMEFHw5v62ifNA8ndXfRqZNktIZK2SmZON33bM1Eb1vuAFatoxW3054vxIgAiWvdkRx+TeBCnUhJnjn0EyFOENeHJsz/ZeD3WRGwpfrpGkZW/ZZ4FRNPiw5gXn9Q2Jeeg41DUs3T+1FaGhKrW8jvI+f/v3/kFTR1Y34Lb/xdKmqzqv7WeDdpKkDqyLQzRfyYncyqPsPt2qWhC/b8U/JaQnpeTzRrSMFtRUzKZ1jAURqSnqaFmHsjTMXALJl4CVS69sI74ZQoOJVgir2h+Af8/lf11SqCHTT4QXqwNrfM4aMULDCBwXaGlj3i8EXnKBAzprybuhOJeUPcnJ5XgLNVZNunK0AMHIA43tqfbt2D8t6oIvMVEVX923gmO2FrlJNERZ4v6qtA9sJhJxcS8pUfUZbN44lLQ/1SwzmMJB5MlyLKKUyfAAzmR1gk+GlZMvo9e064lSOG3rIUL26//TYAm0zm3r2A9zR4Z3ds5/8kpR2DW2jtIG9GSCA4Ok/eK8jk+NlhpcF3IgYATYbXnK2jF7fRng3dHeVVpBUGgg5NZPE828HapR2DdHghepACoT4ogZVl6VyfgFTIwc4HGNyvCzw0vNcCCWnUWNgs+EFf9h569sIr/RAVx8ZK5DN74AVGOD9fA/VCEPooZYqQEowAm9xcaJmHwSYasDsqiV3vINthgEn8sSy6fACB2ZxjghthXdj6MXfk/VyyLNtJom1qedloHRpSRMFvDvpNno8+GUUCKkiBUeyMXiLi1Mz8GUxM8PYtmRu9SwPA5Wclp6HJth0eImb4On17YR3/u2n95cStf9099hNkVXi828vAYvvP+11E+G9s5vBhJNrhkLV3ym8H85GKLpih9HxIuHNTEknneGrQ0iCzYdXuzhPmy2j17cTXtktkslS6F02Te9XQhCHNHgf6z4doFgIhDxunk0U6pRghgnwRmMHcMSEc6I6n4guZWZrpkHMhxdYRJfNV99WeDcM0fxiaSBK72PdJQi2ifDeQmd3f0m3k2e4pu7tVMhd0voPveBLOewDnPjAnjM6/XdHam56WpI533nBKrxWIzqTZz68pGwZvb6t8ErrqK5XoVeOewtv74FBJ8N7J53d0kCP103as0Hq7ARueNFnihY7sqVk8DcaG70mpuam56RhDJgs1f1kpGVrd5SSb5wVXiA9mMNV3154Zw/1BPZTFDgd8t42S1oX6oLLyehlYbpl/rpuhsZ7hpwLMA3QuisRDlSp8EpSBnrzG7CBgvnbKjGDFxK1IFtL+GwZvT4XvKRvdGv9PyO80rruHS++TFPJjlDTd3pQ5V7Ew7vhhyGGpne4xnw4+lFSB6bZDPACMIS7nGE+gPmjVtc8vPhsGb2+fWsbFM3yhEqohL38YklJCRJEAryfdzGw+2KPl8vxqgfHCl988EZ2aiE+AwGI8ulUXMearRjAi8+W0evbDK+0onsHHV4SfBh4N3p7GN6KHd1jPo7FkBlq6NLh7oP6LwPz52TKt1QY1vEiO9ZsxQJe7JGR9Pp2w1swFip5UbdKQh7Mr/6dTT30dktCHvd1pJsi3EX4h50CL/Bn1W4BcuzAPrl77cOLPTKSXt9ueKWt3h4r4F3HAm9Pk7OII9WgyainI7oP6j9gg7xmFEY4XZrjoJFrH17sB1bo9W2Hd/5tBlwvHt4VXnqzJaExH+F0CFCaoGF6REWBF4gOtCtWsV+7pn6zGtuxxSmIM8O4RL4ftagFWVvCbYKn17cdXmmel8FHcsO73EOFt6TH67yPdEuke0hHdR/Uf0BsAK4KxwzcmEdr1O/D8ot8P2pRCzK3pE0e5rHXtx9eaV33T/9Lp0qqcfAWOqmt7nC18qTJNDcYSWWR4QU3GUNtIp0v+2jtIwKvXgPxAG9Bu6unRJ92uNpx/G31uHYQ29zh8rhXMfThtLQLpyO/bWR4c4h/VYRyvjwffxfw4ovEAl7pMS+FMwKAWHgLnU3biVWrvc772FfkaKdvo86RDC8wbYaEEnVECceXTQS8+CIxgVda11Stj14CvBTXu2M7X4o3D30DZHiB9QpIspAZX/ZP+Ql48UViA2/hbd1EL6kLXrLr7elud3NkGrQ5r5luIsILHmiGahj++LYi5i+iCXjxRWIDr7SwXR+9JHilW9rxrldmdzW57/C9pJqAJ8ILRA2o7G0GdqKYMeUg4MUXiRG80vKx7u06IgcivPnbvJhoZMf27nY3R8ALRLyq2JUILxA1oM4dI8yzYRf0aiTgxReJFbzS6rGm0A5u9XSPdeCzXcud6DZ7qpva3UVcBzwlqTxkomo4RYIXjAgQozBwIaS2MZZhm4AXXyRm8OYva+/mp5cMb/42j6sHza6zg/PLVQnoqyfBC05+wY1iAt6IMhnoFfDii8QMXmn+Nh30kuFFu94wu58k3QtK0ayA5kA4ArzgESLwTeMD3mk56EkHAS++SOzglQq2tbdU/5RP21taSfDmL253bQca3C7HDB0csxMRTYeniRp3SIAXyIHB82bJYMALs0ynV8CLLxJDeKWCbR5eeinwSvOcTUCLYXZ51kFGNL10T3vteHjBPBk8XIMyvGlpEL4O2unSAl58kVjCq8P30uCVbgJdr252p3EETpHFwwtQBe/rgb4nlC5JSfBhHxR6Bbz4IjGFl59eKrwrnV5NgwbYVXADx1BYeMGxGDQ1DA3WlDQwFErQ6BXw4ovEFl6FXjBINQSv7Ho15Q2wK0kpUAyKhZfmeJPACGH6tUBsECLSK+DFF4kxvFLB4tYm13ZmVTc5KfDKrjfamkv2u9x5hhklQ5O2rPCCAIKfW1MNzfjoFfDii8QaXjnf2+SqNg9eJeqdLmyUXYQY4QW/yQ9HB6rXAt4fRKBXwIsvYvGhIwjlP9jqbWGllwHeLGdTuLXqFm8r57waXYzwAtEGzK5mJQP8yQs8vQJefJHYwytPLXhYnS8DvNIKj/wuVLtaPE7fDTxH6rGIDV7wQzdQZADMvnHQK+DFF7EDXmnWYqenhQlfFnhnOT1NLS1NnlZdUxMUMcELBg0Qu1C3s9Mr4MUXsQVeKX+Bmy12YIFXWuBsbW9vdfuKOJczsIgFXjBFAbGLWMPATK+AF1/EHnglaZ7PyTJwY4I3y+d2u30dC8wOGSRGeAHsIHYTUetvYHrRM8XAA8okfbCJRbj7gaUp6EA0zdwSi4FrCV6pcIG71UPNmjHBKy28r6OjiO/7rKxigBeYnoDYxaxfgOhFl4uTQ0cMtcRi4JqCV5LmFTlbvRTnywavJBWYnGSIig4vMBZjZRdFL+osEgEvvoiN8Er51/loeQdWeC0TFV7d7CLoRa3vFfDii9gJryQVKLEDIfEQ9/DS2MVEsmHB9MJlBLz4IvbCK0lZC9zOdi8W33iHF0jwcq5bgBeewbsxBLz4Ikmkw9AJAn/g9MIrSVmr3U6s+41veIHFuMkwaLTVuhDt0J5iAa8RE2zSD68kFW5dLLtfFL8ubxzDC5wcwr3aUULRCy4NEvAaMcEmI/BKUv7KZW5na7u3pcVVrQa4Op7hBVJk8Dpzhh1q8N54sJKA14gJNhmDV3a/88L8yg7YVV2tMBxeJmZVFoxJWHjTAcgQO3yYjnSC/DWQcsg1OitBFLgoQy0BL1YLiz4JzogVzlvtkwH2yAS3tLhcLU0ep4/thN3C624w72ZUon1QJSJ4woyNXcSqdRJQsRTfIIj58DVV31LrJxs1wSbtwI/hPIL8GzqKlsITullLVxf5fG6n09na2trqdPuYzl/IWt1h8jpeISGC8u/r8BVdh4oJ8rOWrlpwQ4eiBQwR78plHR0dHIfqCQkZVUGRz+fzLVuJXU9TkJVFX2tTsGqxz9dhYN+akJAOFRT53E6327dV91LGwseWyQvKfIJdoVgrSw5uW1udzm16+C18bJlTltvXYfoGCiEhmj7pU5ILnvZWp3v1PJ6c2MJbbpKrKjUFu0J2aKXb6fG2tLQ0eT3tTudNTADnL1y+ztnq8TY1ydVaBbtCNmmlvB9InpRwKSQ6ne4Vq+bNwtFYsHD5g7LHnZ7JcLV42y3YdCkkxKaV0e1A0wC3t8px7IoVq5YvXzgronnLlz+44ianEmSEwZ2egBPsCtkohd7IWobqanlercnr9bS3K7MUiuT/aveEJ95cM6sfqi3Z7C4kxK6C29q1e9kUhF0tWrlcypIHdTGZ3dWCXSE7VbCtHbMTszoi1N9kdkV+V8hmFSxr5Ti/bHqlr7xox/xDRoSEOJW/zOlhPr9se+RcMrEWRygutNVN3QavcbvtTl+RravUhYSimudzMh8e6ZLd7g22LlIXElIpazFj6CDvDfJ1XCfSDELxo/wFTMeXKUeZWnS4k5CQXi2lnx05PasmQgaheFPBMrLzrZYTZG6xa0IoLrVcOTsSja+8EKfVLdyuULyqcHUYX4jf6TVkItoVimNlIU7fq652NXlbnb4OxIZjIaE4Uvj0vcjpI8pKM3mtr69oVaF4TELxrqyti8Nrd2V5ZXLdvvvmCa8rdE0of6V8/F5YbrfvhlVimCZ0Lalg4dJVCxasXrqU4fwGISEzJEnS/wNPjylCwxf4CwAAAABJRU5ErkJggg=="
                , "geekbang"
                , "G:\\Front-End\\day001\\demo01\\resource");
    }
}