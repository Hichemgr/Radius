<?php
/**
 * Created by PhpStorm.
 * User: raedm
 * Date: 18-Apr-19
 * Time: 16:34
 */

namespace SlimBundle\Repository;

use Doctrine\ORM\EntityRepository;
class ProduitRepository extends EntityRepository
{
    public function FindByLetters($string)
{
    $query = $this->getEntityManager()->createQuery("SELECT a FROM SlimBundle:Produit a WHERE (a.nomproduit like :nomproduit)")
        ->setParameter('nomproduit','%'.$string.'%');

    return $query->getResult();
}

}