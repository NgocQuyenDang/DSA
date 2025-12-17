package FinalExam.Task3;

import java.io.*;
import java.util.*;

class PatientManager
{
    // Đọc dữ liệu từ tệp input.txt
    public static List<Patient> readFromFile(String filename) {
        List<Patient> patients = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while (br.readLine() != null) {
                line = br.readLine();
                String[] data = line.split(";");
                String id = data[0];
                String name = data[1];
                int severity = Integer.parseInt(data[2]);
                patients.add(new Patient(id, name, severity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patients;
    }

    // Trả về hàng đợi ưu tiên từ danh sách bệnh nhân (bệnh nhân có mức độ nghiêm trọng thấp sẽ có độ ưu tiên cao)
    public PriorityQueue<Patient> getPriorityPatients(List<Patient> patients) {
        Queue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.severity));
        for (Patient patient : patients) {
            queue.add(patient);
        }
        return (PriorityQueue<Patient>) queue;
    }

    // Trả về danh sách bệnh nhân có mức độ nghiêm trọng là 1
    public List<Patient> getHighestPriorityPatients(PriorityQueue<Patient> queue) {
        List<Patient> patients = new ArrayList<>();
        for (Patient patient : queue) {
            if (patient.severity > 1) break;
            if (patient.severity == 1) {
                patients.add(patient);
            }
        }
        return patients;
    }
}