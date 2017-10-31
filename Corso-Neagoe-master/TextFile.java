import java.io.*;
import java.util.*;
import java.lang.reflect.*;
/**
 * TextFile - utilizza un generico file di testo con i dati inseriti uno per linea 
 * 
 */
public class TextFile
{
    public TextFile()
    {
    }

    /**
     * restituisce un arrayList del tipo specificato dal parametro con tutti i dati
     * La classe passata in ingresso deve avere un costruttore con parametro strin
     * I dati vengono estratti dalla stringa
     */
    public static <T> ArrayList<T> getData(String filePath, Class<T> cls)
    {
        File file = new File(filePath); 
        ArrayList<T> dati = new ArrayList();
        Class[] paramTypes = { String.class };
        Constructor<T> constructor = null;;

        try
        {
            constructor = cls.getConstructor(paramTypes);
        } catch(Exception e) {
            System.out.println(e);
        }

        try
        {
            // if the file doesn't exists, stop
            if ( !file.exists() )
                return null;

            BufferedReader in =
                new BufferedReader(
                    new FileReader(file));

            String line = in.readLine();
            while(line != null)
            {
                T o = constructor.newInstance(line);
                dati.add(o);
                line = in.readLine();
            }
            in.close();

        }
        catch(Exception ioe)
        {
            System.out.println(ioe);
        }
        return dati;
    }

    public static void saveData(String filePath, ArrayList data)
    {    
        File file = new File(filePath); 

        try
        {
            // if the file doesn't exists, create it
            if (!file.exists())
                file.createNewFile();

            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                        new FileWriter(file)));

            for(Object x : data)
                out.println(x);

            out.close();
        }
        catch(IOException ioe)
        {
            System.out.println(ioe);
        }
    }
}