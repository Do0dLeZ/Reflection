package Task3;

public class TestClass {
    @Save
    private String parameterOne = "need to save parameter one";

    @Save
    public String parameterTwo = "need to save parameter two";

    String parameterThree = "no need to save";

    public String getParameterOne() {
        return parameterOne;
    }

    public String getParameterTwo() {
        return parameterTwo;
    }

    public String getParameterThree() {
        return parameterThree;
    }

    public void setParameterOne(String parameterOne) {
        this.parameterOne = parameterOne;
    }

    public void setParameterTwo(String parameterTwo) {
        this.parameterTwo = parameterTwo;
    }

    public void setParameterThree(String parameterThree) {
        this.parameterThree = parameterThree;
    }
}
