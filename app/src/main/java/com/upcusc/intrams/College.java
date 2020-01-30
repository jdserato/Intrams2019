package com.upcusc.intrams;

import java.util.ArrayList;
import java.util.List;

public class College {
    private String collegeName;
    private String fullName;
    private List<Game> games = new ArrayList();
    private String themeName;
    private int totalScore;

    public College(String str, String str2, String str3) {
        this.collegeName = str;
        this.themeName = str2;
        this.fullName = str3;
    }

    /* access modifiers changed from: 0000 */
    public void addGame(Game game) {
        this.games.add(game);
    }

    /* access modifiers changed from: 0000 */
    public int numberOfGames() {
        return this.games.size();
    }

    /* access modifiers changed from: 0000 */
    public Game getGame(int i) {
        return (Game) this.games.get(i);
    }

    /* access modifiers changed from: 0000 */
    public int getGameSize() {
        return this.games.size();
    }

    /* access modifiers changed from: 0000 */
    public void refreshGames() {
        for (Game clear : this.games) {
            clear.clear();
        }
    }

    public String toString() {
        return this.fullName;
    }

    public String getCollegeName() {
        return this.collegeName;
    }

    public void setGames(List<Game> list) {
        this.games = list;
    }

    public String getThemeName() {
        return "House ".concat(this.themeName);
    }

    /* access modifiers changed from: 0000 */
    public int getTotalScore() {
        int i = 0;
        for (Game game : this.games) {
            if (!game.isOnce() || game.getGames().size() != 1) {
                for (Game game2 : game.getGames()) {
                    if (game2.getCollege1() != this || game2.getStanding1() == 0) {
                        if (game2.getCollege2() != this || game2.getStanding2() == 0) {
                            if (game2.getCollege3() != this || game2.getStanding3() == 0) {
                                if (game2.getCollege4() == this && game2.getStanding4() != 0) {
                                    if (game2.isMajor()) {
                                        if (game2.getStanding4() == 1) {
                                            i += 30;
                                        } else if (game2.getStanding4() == 2) {
                                            i += 25;
                                        } else if (game2.getStanding4() == 3) {
                                            i += 20;
                                        } else if (game2.getStanding4() == 4) {
                                            i += 15;
                                        }
                                    } else if (game2.getStanding4() == 1) {
                                        i += 15;
                                    } else if (game2.getStanding4() == 2) {
                                        i += 12;
                                    } else if (game2.getStanding4() == 3) {
                                        i += 9;
                                    } else if (game2.getStanding4() == 4) {
                                        i += 6;
                                    }
                                }
                            } else if (game2.isMajor()) {
                                if (game2.getStanding3() == 1) {
                                    i += 30;
                                } else if (game2.getStanding3() == 2) {
                                    i += 25;
                                } else if (game2.getStanding3() == 3) {
                                    i += 20;
                                } else if (game2.getStanding3() == 4) {
                                    i += 15;
                                }
                            } else if (game2.getStanding3() == 1) {
                                i += 15;
                            } else if (game2.getStanding3() == 2) {
                                i += 12;
                            } else if (game2.getStanding3() == 3) {
                                i += 9;
                            } else if (game2.getStanding3() == 4) {
                                i += 6;
                            }
                        } else if (game2.isMajor()) {
                            if (game2.getStanding2() == 1) {
                                i += 30;
                            } else if (game2.getStanding2() == 2) {
                                i += 25;
                            } else if (game2.getStanding2() == 3) {
                                i += 20;
                            } else if (game2.getStanding2() == 4) {
                                i += 15;
                            }
                        } else if (game2.getStanding2() == 1) {
                            i += 15;
                        } else if (game2.getStanding2() == 2) {
                            i += 12;
                        } else if (game2.getStanding2() == 3) {
                            i += 9;
                        } else if (game2.getStanding2() == 4) {
                            i += 6;
                        }
                    } else if (game2.isMajor()) {
                        if (game2.getStanding1() == 1) {
                            i += 30;
                        } else if (game2.getStanding1() == 2) {
                            i += 25;
                        } else if (game2.getStanding1() == 3) {
                            i += 20;
                        } else if (game2.getStanding1() == 4) {
                            i += 15;
                        }
                    } else if (game2.getStanding1() == 1) {
                        i += 15;
                    } else if (game2.getStanding1() == 2) {
                        i += 12;
                    } else if (game2.getStanding1() == 3) {
                        i += 9;
                    } else if (game2.getStanding1() == 4) {
                        i += 6;
                    }
                }
            } else {
                Game game3 = (Game) game.getGames().get(0);
                if (this.collegeName.equals("CCAD")) {
                    if (game.isMajor()) {
                        if (game3.getStanding1() == 1) {
                            i += 30;
                        } else if (game3.getStanding1() == 2) {
                            i += 25;
                        } else if (game3.getStanding1() == 3) {
                            i += 20;
                        } else if (game3.getStanding1() == 4) {
                            i += 15;
                        }
                    } else if (game3.getStanding1() == 1) {
                        i += 15;
                    } else if (game3.getStanding1() == 2) {
                        i += 12;
                    } else if (game3.getStanding1() == 3) {
                        i += 9;
                    } else if (game3.getStanding1() == 4) {
                        i += 6;
                    }
                } else if (this.collegeName.equals("COS")) {
                    if (game.isMajor()) {
                        if (game3.getStanding2() == 1) {
                            i += 30;
                        } else if (game3.getStanding2() == 2) {
                            i += 25;
                        } else if (game3.getStanding2() == 3) {
                            i += 20;
                        } else if (game3.getStanding2() == 4) {
                            i += 15;
                        }
                    } else if (game3.getStanding2() == 1) {
                        i += 15;
                    } else if (game3.getStanding2() == 2) {
                        i += 12;
                    } else if (game3.getStanding2() == 3) {
                        i += 9;
                    } else if (game3.getStanding2() == 4) {
                        i += 6;
                    }
                } else if (this.collegeName.equals("CSS")) {
                    if (game.isMajor()) {
                        if (game3.getStanding3() == 1) {
                            i += 30;
                        } else if (game3.getStanding3() == 2) {
                            i += 25;
                        } else if (game3.getStanding3() == 3) {
                            i += 20;
                        } else if (game3.getStanding3() == 4) {
                            i += 15;
                        }
                    } else if (game3.getStanding3() == 1) {
                        i += 15;
                    } else if (game3.getStanding3() == 2) {
                        i += 12;
                    } else if (game3.getStanding3() == 3) {
                        i += 9;
                    } else if (game3.getStanding3() == 4) {
                        i += 6;
                    }
                } else if (game.isMajor()) {
                    if (game3.getStanding4() == 1) {
                        i += 30;
                    } else if (game3.getStanding4() == 2) {
                        i += 25;
                    } else if (game3.getStanding4() == 3) {
                        i += 20;
                    } else if (game3.getStanding4() == 4) {
                        i += 15;
                    }
                } else if (game3.getStanding4() == 1) {
                    i += 15;
                } else if (game3.getStanding4() == 2) {
                    i += 12;
                } else if (game3.getStanding4() == 3) {
                    i += 9;
                } else if (game3.getStanding4() == 4) {
                    i += 6;
                }
            }
        }
        return i;
    }
}
