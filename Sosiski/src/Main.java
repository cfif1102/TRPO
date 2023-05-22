import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main{
    public static JComboBox HotdogTypeBox;
    public static JList HotdogList;
    public static JButton AddHotdogBtn, DeleteHotdogBtn, TotalPriceBtn, AveragePriceBtn, CalcByHotdogBtn;
    public static DefaultListModel hotdogListModel;

    public static RepClass HotdogsRepo = new RepClass();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Хотдожная");

        hotdogListModel = new DefaultListModel();

        HotdogList = new JList(hotdogListModel);

        HotdogList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        HotdogList.setLayoutOrientation(JList.VERTICAL_WRAP);
        HotdogList.setBounds(20, 20, 300, 400);

        frame.add(HotdogList);

        HotdogTypeBox = new JComboBox(new String[] {"Берлинка", "Мастер", "Хантер"});

        HotdogTypeBox.setBounds(330, 20, 100, 20);

        frame.add(HotdogTypeBox);

        AddHotdogBtn = new JButton();

        AddHotdogBtn.setBounds(330, 50, 100, 20);
        AddHotdogBtn.setText("Добавить");
        frame.add(AddHotdogBtn);

        DeleteHotdogBtn = new JButton();

        DeleteHotdogBtn.setBounds(330, 80, 100, 20);
        DeleteHotdogBtn.setText("Удалить");
        frame.add(DeleteHotdogBtn);

        TotalPriceBtn = new JButton();

        TotalPriceBtn.setBounds(330, 110, 100, 20);
        TotalPriceBtn.setText("Доход");
        frame.add(TotalPriceBtn);

        CalcByHotdogBtn = new JButton();

        CalcByHotdogBtn.setBounds(330, 170, 100, 20);
        CalcByHotdogBtn.setText("По хотдогу");
        frame.add(CalcByHotdogBtn);

        CalcByHotdogBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, CalcHotdogSpecies((ArrayList<Hotdog>) HotdogsRepo.getHotdogs()));
            }
        });

        TotalPriceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Hotdog> hotdogs = HotdogsRepo.getHotdogs();

                double totalPrice = CalcTotalPrice((ArrayList<Hotdog>) hotdogs);

                JOptionPane.showMessageDialog(null, "Общий доход: " + totalPrice);
            }
        });

        AveragePriceBtn = new JButton();
        AveragePriceBtn.setBounds(330, 140, 100, 20);
        AveragePriceBtn.setText("Средний");
        frame.add(AveragePriceBtn);

        AveragePriceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Hotdog> hotdogs = HotdogsRepo.getHotdogs();

                double totalPrice = Average((ArrayList<Hotdog>) hotdogs);

                JOptionPane.showMessageDialog(null, "Средняя цена: " + totalPrice);
            }
        });

        DeleteHotdogBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = HotdogList.getSelectedIndex();

                if (selectedIndex == -1)
                {
                    JOptionPane.showMessageDialog(null, "Выберите ход-дог для удаления!");
                    return;
                }

                Hotdog hotdogToDelete = HotdogsRepo.getHotdogs().get(selectedIndex);

                HotdogsRepo.removeHotdog(hotdogToDelete);

                ShowHotdogs();
            }
        });
        AddHotdogBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = HotdogTypeBox.getSelectedIndex();

                if (selectedIndex == -1)
                {
                    JOptionPane.showMessageDialog(null, "Для добавления хот-дога выберите тип!");
                    return;
                }

                String hType = HotdogTypeBox.getSelectedItem().toString();

                HotdogsRepo.addHotdog(hType);

                ShowHotdogs();
            }
        });

        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void ShowHotdogs()
    {
        List<Hotdog> hotdogs = HotdogsRepo.getHotdogs();

        hotdogListModel.clear();

        for (Hotdog hotdog : hotdogs)
        {
            hotdogListModel.addElement(hotdog.getClass().getName());
        }
    }

    //как было
    public static double CalcTotalPrice(ArrayList<Hotdog> hotdogs) {
        double price = 0;

        for (Hotdog hotdog : hotdogs) {
            price += hotdog.price();
        }

        return price;
    }
    //как было
    public static double Average(ArrayList<Hotdog> hotdogs) {
        return CalcTotalPrice(hotdogs) / hotdogs.size();
    }

    //как было
    public static String  CalcHotdogSpecies(ArrayList<Hotdog> hotdogs) {
        int masterAmount = 0, hunterAmount = 0, berlinkaAmount = 0;

        for (Hotdog hotdog : hotdogs) {
            if (hotdog.getClass() == MasterDog.class) {
                masterAmount++;
            }
            if (hotdog.getClass() == Berlinka.class) {
                berlinkaAmount++;
            }
            if (hotdog.getClass() == HunterDog.class) {
                hunterAmount++;
            }
        }

        String result = "Продано по типам:\n";

        result += "\nMasterDog: " + masterAmount;
        result += "\nBerlinka: " + berlinkaAmount;
        result += "\nHunterDog: " + hunterAmount;

        return result;
    }
}