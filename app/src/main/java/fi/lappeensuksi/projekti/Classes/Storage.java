package fi.lappeensuksi.projekti.Classes;

import java.util.ArrayList;

import fi.lappeensuksi.projekti.Lutemons.Lutemon;

public class Storage {
    private ArrayList<Lutemon> allLutemons = new ArrayList<>();
    private ArrayList<Lutemon> homeLutemons = new ArrayList<>();
    private ArrayList<Lutemon> trainingLutemons = new ArrayList<>();
    private ArrayList<Lutemon> battleLutemons = new ArrayList<>();

    private static Storage storage = null;

    private Storage(){}

    public static Storage getInstance(){
        if(storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void addLutemon(Lutemon lutemon) {
        allLutemons.add(lutemon);
        homeLutemons.add(lutemon); // default location = home
    }

    public ArrayList<Lutemon> getAllLutemons() {
        return allLutemons;
    }

    public ArrayList<Lutemon> getHomeLutemons() {
        return homeLutemons;
    }

    public ArrayList<Lutemon> getTrainingLutemons() {
        return trainingLutemons;
    }

    public ArrayList<Lutemon> getBattleLutemons() {
        return battleLutemons;
    }

    public Lutemon getLutemonById(ArrayList<Lutemon> listOfLutemons, int id) {
        for(Lutemon lutemon : listOfLutemons) {
            if(lutemon.getId() == id) {
                return lutemon;
            }
        }
        return null;
    }

    public void moveLutemon(int id, String locationFrom, String locationTo) {
        switch(locationFrom) {
            case "home":
                if(locationTo.equals("training")) {
                    Lutemon lutemonToMove = getLutemonById(homeLutemons, id);
                    lutemonToMove.setLocation("training");
                    trainingLutemons.add(lutemonToMove);
                    homeLutemons.remove(lutemonToMove);
                } else if(locationTo.equals("battle")) {
                    Lutemon lutemonToMove = getLutemonById(homeLutemons, id);
                    lutemonToMove.setLocation("battle");
                    battleLutemons.add(lutemonToMove);
                    homeLutemons.remove(lutemonToMove);
                }
                break;
            case "training":
                if(locationTo.equals("home")) {
                    Lutemon lutemonToMove = getLutemonById(trainingLutemons, id);
                    lutemonToMove.setLocation("home");
                    homeLutemons.add(lutemonToMove);
                    trainingLutemons.remove(lutemonToMove);
                } else if(locationTo.equals("battle")) {
                    Lutemon lutemonToMove = getLutemonById(trainingLutemons, id);
                    lutemonToMove.setLocation("battle");
                    battleLutemons.add(lutemonToMove);
                    trainingLutemons.remove(lutemonToMove);
                }
                break;
            case "battle":
                if(locationTo.equals("home")) {
                    Lutemon lutemonToMove = getLutemonById(battleLutemons, id);
                    lutemonToMove.setLocation("home");
                    homeLutemons.add(lutemonToMove);
                    battleLutemons.remove(lutemonToMove);
                } else if(locationTo.equals("training")) {
                    Lutemon lutemonToMove = getLutemonById(battleLutemons, id);
                    lutemonToMove.setLocation("training");
                    trainingLutemons.add(lutemonToMove);
                    battleLutemons.remove(lutemonToMove);
                }
                break;
        }
    }

    public void trainLutemon(int id) {
        Lutemon lutemonToTrain = getLutemonById(trainingLutemons, id);
        lutemonToTrain.setExperience(lutemonToTrain.getExperience() + 1);
        lutemonToTrain.setAttack(lutemonToTrain.getAttack() + 1);
    }

    /* THIS IS FOR SAVING AND LOADING LUTEMONS
    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput("allLutemons.data", Context.MODE_PRIVATE));
            lutemonWriter.writeObject(allLutemons);
            lutemonWriter.close();
        } catch (IOException e) {
            System.out.println("Saving Lutemons was not successful");
        }
    }

    public void loadLutemons(Context context) {
        try {
            ObjectInputStream lutemonReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            allLutemons = (ArrayList<Lutemon>) LutemonsReader.readObject();
            lutemonReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Loading Lutemons was not successful");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Loading Lutemons was not successful");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Loading Lutemons was not successful");
            e.printStackTrace();
        }
    }
    * */
}
