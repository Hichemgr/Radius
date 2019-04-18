<?php

namespace SlimBundle\Repository;


use Doctrine\ORM\EntityRepository;

class PromotionRepository extends EntityRepository
{





    public function RechercherPromotion($nom){
        $q=$this->getEntityManager()->createQuery("select c from SlimBundle:Promotion c where  c.nome =:nom")->setParameter('nom',$nom);
        return $q->getResult();
    }

}
