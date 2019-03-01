public class JSONFormatter {

    JSONFormatter(){

    }

    public String getJson(Patient patient){
        StringBuilder builder = new StringBuilder();
        builder.append("{");

        String[] fields = patient.getFields();

        for(String field : fields){
            builder.append('"');
            builder.append(field);
            builder.append("\" : \"");
            builder.append(patient.get(field));
            builder.append("\",\n");
        }

        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append("}");

        return builder.toString();

    }


}
