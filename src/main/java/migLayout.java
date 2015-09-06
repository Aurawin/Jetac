
public class migLayout {
    public static Boolean DebugOff= false;
    public static Boolean DebugOn= true;
    public static Boolean Debug= DebugOff;

    private static String noGap = ", gap 0 0";
    private static String noInsets =", ins 0 0";
    private static String tagDebug = ", debug";
    private static String hideMode = ", hidemode 2";
    public static class Wrapper{
        public static String loConstraints = "nogrid, fill"+noGap+noInsets;
        public static class Debug {
            public static String loConstraints = Wrapper.loConstraints + tagDebug;
        }
        public static String getLoConstraints(boolean debug){
            return (debug==true) ? Wrapper.Debug.loConstraints : loConstraints;
        }
        public static class Owner{
            public static String loConstraints = "nogrid, fill"+noGap+noInsets;
            public static class Debug {
                public static String loConstraints = Owner.loConstraints + tagDebug;
            }
            public static String getLoConstraints(boolean debug){
                return (debug==true) ? Owner.Debug.loConstraints : loConstraints;
            }
        }
    }
    public static class Object{
        public static String Panel = "nogrid, flowx, fillx";
        public static String loConstraints = Panel+noGap+noInsets+hideMode;
        public static class Debug{
            public static String loConstraints = Object.loConstraints+tagDebug;
        }
        public static String getLoConstraints(boolean debug){
            return (debug==true) ? Object.Debug.loConstraints : loConstraints;
        }
        public static class View{
            public static String loConstraints = "nogrid, aligny top, fillx, flowx" + noGap+noInsets+hideMode;
            public static class Debug {
                public static String loConstraints = View.loConstraints + tagDebug;
            }
            public static class Header{
                public static String loConstraints = "nogrid, novisualpadding, aligny top, flowx, fillx" + noGap+noInsets+hideMode;
                public static class Debug {
                    public static String loConstraints = Header.loConstraints + tagDebug;
                }
                public static String getLoConstraints(boolean debug){
                    return (debug==true) ? Header.Debug.loConstraints : loConstraints;
                }
            }

            public static class Client{
                public static String loConstraints = "nogrid, novisualpadding, aligny top, flowy, fillx" + noGap+noInsets+hideMode;
                public static class Debug {
                    public static String loConstraints = Client.loConstraints + tagDebug;
                }
                public static String getLoConstraints(boolean debug){
                    return (debug==true) ? Client.Debug.loConstraints : loConstraints;
                }
            }
            public static String getLoConstraints(boolean debug){
                return (debug==true) ? View.Debug.loConstraints : loConstraints;
            }

        }
        public static class Toolbar{
            public static String loConstraints = "flowx, aligny top"+noGap+noInsets+hideMode;
            public static class Debug{
                public static String loConstraints = Toolbar.loConstraints+tagDebug;
            }
            public static String getLoConstraints(boolean debug){
                return (debug==true) ? Toolbar.Debug.loConstraints : loConstraints;
            }
        }
        public static class Item{
            public static class Simple{
                public static String loConstraints="novisualpadding, aligny top, fillx, flowx"+noGap+hideMode;
                public static class Debug{
                    public static String loConstraints=Simple.loConstraints+tagDebug;
                }
                public static String getLoConstraints(boolean debug){
                    return (debug==true) ? Simple.Debug.loConstraints : loConstraints;
                }

            }
        }
    }
}
