package com.busyqa.crm.repo;

//@Transactional
//public interface UserRepository extends UserBaseRepository<User> {
//
//}





// QUERY SAMPLE

//    @Override
//    public List<Client> getAllLead() {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Client> cq = cb.createQuery(Client.class);
//        Root<Client> client = cq.from(Client.class);
//
//        cq.select(client).where(cb.equal(client.get("clientStatus"), "Lead"));
//        TypedQuery<Client> q = entityManager.createQuery(cq);
//        List<Client> allLeads = q.getResultList();
//        return allLeads;
//    }
//


//    @Override
//    public List<Client> getAllClient() {
//        String jpql = "SELECT c FROM Client c ORDER BY c.id";
//        return (List<Client>) entityManager.createQuery(jpql)
//                .getResultStream()
//                .collect(Collectors.toList());
//    }



//    @Override
//    public boolean clientExist(String email) {
//        String jpql = "from Client as a WHERE a.email =: email";
//        int count = entityManager.createQuery(jpql)
//                .setParameter("email",email)
//                .getResultList().size();
//        return count > 0;
//    }