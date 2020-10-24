package IRepository;

import model.Transaction;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Code Freak Tanveer on 12/03/2017.
 */

public interface ITransaction {
    @GET("PartyJournal/GetPartyJournalReportById")
    Call<Transaction[]> getTransactionBuId(@Query("party_id") int partyId,@Query("from_date") String fromDate,@Query("to_date") String toDate);

}
